package La;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import q9.InterfaceC5162a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R4\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LLa/d;", "LKa/j;", "Lv9/i;", "", "input", "", "startIndex", "limit", "Lkotlin/Function2;", "Lkotlin/Pair;", "getNextMatch", "<init>", "(Ljava/lang/CharSequence;IILp9/p;)V", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "Ljava/lang/CharSequence;", Const.INTENT_KEY_PKGNAME, "I", "c", Const.INTENT_KEY_UMID, "Lp9/p;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: La.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0954d implements Ka.j<C5680i> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CharSequence input;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int startIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int limit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final p9.p<CharSequence, Integer, Pair<Integer, Integer>> getNextMatch;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u0006#"}, d2 = {"La/d$a", "", "Lv9/i;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", Const.INTENT_KEY_PKGNAME, "()Lv9/i;", "", "hasNext", "()Z", "", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "getCurrentStartIndex", "setCurrentStartIndex", "currentStartIndex", "c", "getNextSearchIndex", "setNextSearchIndex", "nextSearchIndex", Const.INTENT_KEY_UMID, "Lv9/i;", "getNextItem", "setNextItem", "(Lv9/i;)V", "nextItem", "e", "getCounter", "setCounter", "counter", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: La.d$a */
    public static final class a implements Iterator<C5680i>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int nextState = -1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int currentStartIndex;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int nextSearchIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public C5680i nextItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int counter;

        public a() {
            int iN = C5685n.n(C0954d.this.startIndex, 0, C0954d.this.input.length());
            this.currentStartIndex = iN;
            this.nextSearchIndex = iN;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.nextSearchIndex
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.nextState = r1
                r0 = 0
                r6.nextItem = r0
                return
            Lb:
                La.d r0 = La.C0954d.this
                int r0 = La.C0954d.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.counter
                int r0 = r0 + r3
                r6.counter = r0
                La.d r4 = La.C0954d.this
                int r4 = La.C0954d.e(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.nextSearchIndex
                La.d r4 = La.C0954d.this
                java.lang.CharSequence r4 = La.C0954d.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                v9.i r0 = new v9.i
                int r1 = r6.currentStartIndex
                La.d r4 = La.C0954d.this
                java.lang.CharSequence r4 = La.C0954d.d(r4)
                int r4 = La.H.n0(r4)
                r0.<init>(r1, r4)
                r6.nextItem = r0
                r6.nextSearchIndex = r2
                goto L9b
            L46:
                La.d r0 = La.C0954d.this
                p9.p r0 = La.C0954d.c(r0)
                La.d r4 = La.C0954d.this
                java.lang.CharSequence r4 = La.C0954d.d(r4)
                int r5 = r6.nextSearchIndex
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L76
                v9.i r0 = new v9.i
                int r1 = r6.currentStartIndex
                La.d r4 = La.C0954d.this
                java.lang.CharSequence r4 = La.C0954d.d(r4)
                int r4 = La.H.n0(r4)
                r0.<init>(r1, r4)
                r6.nextItem = r0
                r6.nextSearchIndex = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.currentStartIndex
                v9.i r4 = v9.C5685n.s(r4, r2)
                r6.nextItem = r4
                int r2 = r2 + r0
                r6.currentStartIndex = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.nextSearchIndex = r2
            L9b:
                r6.nextState = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: La.C0954d.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C5680i next() {
            if (this.nextState == -1) {
                a();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            C5680i c5680i = this.nextItem;
            kotlin.jvm.internal.p.g(c5680i, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return c5680i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState == -1) {
                a();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0954d(CharSequence input, int i10, int i11, p9.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(getNextMatch, "getNextMatch");
        this.input = input;
        this.startIndex = i10;
        this.limit = i11;
        this.getNextMatch = getNextMatch;
    }

    @Override // Ka.j
    public Iterator<C5680i> iterator() {
        return new a();
    }
}
