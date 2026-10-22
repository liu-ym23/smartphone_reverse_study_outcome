package go;

import a1.a;
import android.content.Context;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.logging.Logger;
import n.f;

/* loaded from: classes.dex */
public class Seq {
    private static final int NULL_REFNUM = 41;
    static final RefTracker tracker;
    private static Logger log = Logger.getLogger("GoSeq");
    public static final Ref nullRef = new Ref(41, null);
    private static final GoRefQueue goRefQueue = new GoRefQueue();

    public interface GoObject {
        int incRefnum();
    }

    public static class GoRef extends PhantomReference<GoObject> {
        final int refnum;

        public GoRef(int i2, GoObject goObject, GoRefQueue goRefQueue) {
            super(goObject, goRefQueue);
            if (i2 > 0) {
                throw new RuntimeException(f.c(i2, "GoRef instantiated with a Java refnum "));
            }
            this.refnum = i2;
        }
    }

    public static class GoRefQueue extends ReferenceQueue<GoObject> {
        private final Collection<GoRef> refs = Collections.synchronizedCollection(new HashSet());

        public GoRefQueue() {
            Thread thread = new Thread(new Runnable() { // from class: go.Seq.GoRefQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            GoRef goRef = (GoRef) GoRefQueue.this.remove();
                            GoRefQueue.this.refs.remove(goRef);
                            Seq.destroyRef(goRef.refnum);
                            goRef.clear();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.setName("GoRefQueue Finalizer Thread");
            thread.start();
        }

        public void track(int i2, GoObject goObject) {
            this.refs.add(new GoRef(i2, goObject, this));
        }
    }

    public interface Proxy extends GoObject {
    }

    public static final class Ref {
        public final Object obj;
        private int refcnt;
        public final int refnum;

        public Ref(int i2, Object obj) {
            if (i2 < 0) {
                throw new RuntimeException(f.c(i2, "Ref instantiated with a Go refnum "));
            }
            this.refnum = i2;
            this.refcnt = 0;
            this.obj = obj;
        }

        public static /* synthetic */ int access$110(Ref ref) {
            int i2 = ref.refcnt;
            ref.refcnt = i2 - 1;
            return i2;
        }

        public void inc() {
            int i2 = this.refcnt;
            if (i2 != Integer.MAX_VALUE) {
                this.refcnt = i2 + 1;
                return;
            }
            throw new RuntimeException("refnum " + this.refnum + " overflow");
        }
    }

    public static final class RefMap {
        private int next = 0;
        private int live = 0;
        private int[] keys = new int[16];
        private Ref[] objs = new Ref[16];

        private void grow() {
            Ref[] refArr;
            int iRoundPow2 = roundPow2(this.live) * 2;
            int[] iArr = this.keys;
            if (iRoundPow2 > iArr.length) {
                iArr = new int[iArr.length * 2];
                refArr = new Ref[this.objs.length * 2];
            } else {
                refArr = this.objs;
            }
            int i2 = 0;
            int i10 = 0;
            while (true) {
                int[] iArr2 = this.keys;
                if (i2 >= iArr2.length) {
                    break;
                }
                Ref ref = this.objs[i2];
                if (ref != null) {
                    iArr[i10] = iArr2[i2];
                    refArr[i10] = ref;
                    i10++;
                }
                i2++;
            }
            for (int i11 = i10; i11 < iArr.length; i11++) {
                iArr[i11] = 0;
                refArr[i11] = null;
            }
            this.keys = iArr;
            this.objs = refArr;
            this.next = i10;
            if (this.live == i10) {
                return;
            }
            throw new RuntimeException("bad state: live=" + this.live + ", next=" + this.next);
        }

        private static int roundPow2(int i2) {
            int i10 = 1;
            while (i10 < i2) {
                i10 *= 2;
            }
            return i10;
        }

        public Ref get(int i2) {
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i2);
            if (iBinarySearch >= 0) {
                return this.objs[iBinarySearch];
            }
            return null;
        }

        public void put(int i2, Ref ref) {
            if (ref == null) {
                throw new RuntimeException(a.f(i2, "put a null ref (with key ", ")"));
            }
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i2);
            if (iBinarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[iBinarySearch] == null) {
                    refArr[iBinarySearch] = ref;
                    this.live++;
                }
                if (refArr[iBinarySearch] != ref) {
                    throw new RuntimeException(a.f(i2, "replacing an existing ref (with key ", ")"));
                }
                return;
            }
            if (this.next >= this.keys.length) {
                grow();
                iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i2);
            }
            int i10 = ~iBinarySearch;
            int i11 = this.next;
            if (i10 < i11) {
                int[] iArr = this.keys;
                int i12 = i10 + 1;
                System.arraycopy(iArr, i10, iArr, i12, i11 - i10);
                Ref[] refArr2 = this.objs;
                System.arraycopy(refArr2, i10, refArr2, i12, this.next - i10);
            }
            this.keys[i10] = i2;
            this.objs[i10] = ref;
            this.live++;
            this.next++;
        }

        public void remove(int i2) {
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i2);
            if (iBinarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[iBinarySearch] != null) {
                    refArr[iBinarySearch] = null;
                    this.live--;
                }
            }
        }
    }

    public static final class RefTracker {
        private static final int REF_OFFSET = 42;
        private int next = REF_OFFSET;
        private final RefMap javaObjs = new RefMap();
        private final IdentityHashMap<Object, Integer> javaRefs = new IdentityHashMap<>();

        public synchronized void dec(int i2) {
            if (i2 <= 0) {
                Seq.log.severe("dec request for Go object " + i2);
                return;
            }
            if (i2 == Seq.nullRef.refnum) {
                return;
            }
            Ref ref = this.javaObjs.get(i2);
            if (ref == null) {
                throw new RuntimeException("referenced Java object is not found: refnum=" + i2);
            }
            Ref.access$110(ref);
            if (ref.refcnt <= 0) {
                this.javaObjs.remove(i2);
                this.javaRefs.remove(ref.obj);
            }
        }

        public synchronized Ref get(int i2) {
            if (i2 < 0) {
                throw new RuntimeException("ref called with Go refnum " + i2);
            }
            if (i2 == 41) {
                return Seq.nullRef;
            }
            Ref ref = this.javaObjs.get(i2);
            if (ref != null) {
                return ref;
            }
            throw new RuntimeException("unknown java Ref: " + i2);
        }

        public synchronized int inc(Object obj) {
            if (obj == null) {
                return 41;
            }
            if (obj instanceof Proxy) {
                return ((Proxy) obj).incRefnum();
            }
            Integer numValueOf = this.javaRefs.get(obj);
            if (numValueOf == null) {
                int i2 = this.next;
                if (i2 == Integer.MAX_VALUE) {
                    throw new RuntimeException("createRef overflow for " + obj);
                }
                this.next = i2 + 1;
                numValueOf = Integer.valueOf(i2);
                this.javaRefs.put(obj, numValueOf);
            }
            int iIntValue = numValueOf.intValue();
            Ref ref = this.javaObjs.get(iIntValue);
            if (ref == null) {
                ref = new Ref(iIntValue, obj);
                this.javaObjs.put(iIntValue, ref);
            }
            ref.inc();
            return iIntValue;
        }

        public synchronized void incRefnum(int i2) {
            Ref ref = this.javaObjs.get(i2);
            if (ref == null) {
                throw new RuntimeException("referenced Java object is not found: refnum=" + i2);
            }
            ref.inc();
        }
    }

    static {
        System.loadLibrary("gojni");
        init();
        Universe.touch();
        tracker = new RefTracker();
    }

    private Seq() {
    }

    public static void decRef(int i2) {
        tracker.dec(i2);
    }

    public static native void destroyRef(int i2);

    public static Ref getRef(int i2) {
        return tracker.get(i2);
    }

    public static int incGoObjectRef(GoObject goObject) {
        return goObject.incRefnum();
    }

    public static native void incGoRef(int i2, GoObject goObject);

    public static int incRef(Object obj) {
        return tracker.inc(obj);
    }

    public static void incRefnum(int i2) {
        tracker.incRefnum(i2);
    }

    private static native void init();

    public static void setContext(Context context) {
        setContext((Object) context);
    }

    public static native void setContext(Object obj);

    public static void touch() {
    }

    public static void trackGoRef(int i2, GoObject goObject) {
        if (i2 > 0) {
            throw new RuntimeException(f.c(i2, "trackGoRef called with Java refnum "));
        }
        goRefQueue.track(i2, goObject);
    }
}
