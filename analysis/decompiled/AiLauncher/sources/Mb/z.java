package Mb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\n\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\u0013\u0010&\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u00100\u001a\u0004\u0018\u00010-8G¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00102\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010#R\u0011\u00104\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b3\u0010 R\u0013\u00106\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b5\u0010%¨\u00067"}, d2 = {"LMb/z;", "", "Lokio/ByteString;", SingleFileBundle.KEY_BYTES, "<init>", "(Lokio/ByteString;)V", "", "child", "n", "(Ljava/lang/String;)LMb/z;", "", "normalize", "m", "(LMb/z;Z)LMb/z;", "other", "l", "(LMb/z;)LMb/z;", "Ljava/io/File;", "toFile", "()Ljava/io/File;", "Ljava/nio/file/Path;", "p", "()Ljava/nio/file/Path;", "", Const.INTENT_KEY_APIKEY, "(LMb/z;)I", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lokio/ByteString;", Const.INTENT_KEY_PKGNAME, "()Lokio/ByteString;", "c", "()LMb/z;", Parameters.ROOT, "", "e", "()Ljava/util/List;", "segmentsBytes", "isAbsolute", "()Z", "", "q", "()Ljava/lang/Character;", "volumeLetter", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "nameBytes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "name", "k", "parent", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class z implements Comparable<z> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String f4761c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ByteString bytes;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LMb/z$a;", "", "<init>", "()V", "", "", "normalize", "LMb/z;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)LMb/z;", "Ljava/io/File;", Const.INTENT_KEY_APIKEY, "(Ljava/io/File;Z)LMb/z;", "Ljava/nio/file/Path;", "c", "(Ljava/nio/file/Path;Z)LMb/z;", "DIRECTORY_SEPARATOR", "Ljava/lang/String;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.z$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ z d(Companion companion, File file, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.a(file, z10);
        }

        public static /* synthetic */ z e(Companion companion, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.b(str, z10);
        }

        public static /* synthetic */ z f(Companion companion, Path path, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.c(path, z10);
        }

        public final z a(File file, boolean z10) {
            kotlin.jvm.internal.p.i(file, "<this>");
            String string = file.toString();
            kotlin.jvm.internal.p.h(string, "toString(...)");
            return b(string, z10);
        }

        public final z b(String str, boolean z10) {
            kotlin.jvm.internal.p.i(str, "<this>");
            return Nb.e.k(str, z10);
        }

        public final z c(Path path, boolean z10) {
            kotlin.jvm.internal.p.i(path, "<this>");
            return b(path.toString(), z10);
        }

        public Companion() {
        }
    }

    static {
        String separator = File.separator;
        kotlin.jvm.internal.p.h(separator, "separator");
        f4761c = separator;
    }

    public z(ByteString bytes) {
        kotlin.jvm.internal.p.i(bytes, "bytes");
        this.bytes = bytes;
    }

    public static /* synthetic */ z o(z zVar, z zVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return zVar.m(zVar2, z10);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(z other) {
        kotlin.jvm.internal.p.i(other, "other");
        return getBytes().compareTo(other.getBytes());
    }

    /* renamed from: b, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    public final z c() {
        int iO = Nb.e.o(this);
        if (iO == -1) {
            return null;
        }
        return new z(getBytes().N(0, iO));
    }

    public final List<ByteString> e() {
        ArrayList arrayList = new ArrayList();
        int iO = Nb.e.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < getBytes().K() && getBytes().l(iO) == 92) {
            iO++;
        }
        int iK = getBytes().K();
        int i10 = iO;
        while (iO < iK) {
            if (getBytes().l(iO) == 47 || getBytes().l(iO) == 92) {
                arrayList.add(getBytes().N(i10, iO));
                i10 = iO + 1;
            }
            iO++;
        }
        if (i10 < getBytes().K()) {
            arrayList.add(getBytes().N(i10, getBytes().K()));
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        return (other instanceof z) && kotlin.jvm.internal.p.d(((z) other).getBytes(), getBytes());
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final String i() {
        return j().Q();
    }

    public final boolean isAbsolute() {
        return Nb.e.o(this) != -1;
    }

    public final ByteString j() {
        int iL = Nb.e.l(this);
        return iL != -1 ? ByteString.O(getBytes(), iL + 1, 0, 2, null) : (q() == null || getBytes().K() != 2) ? getBytes() : ByteString.f37756e;
    }

    public final z k() {
        if (kotlin.jvm.internal.p.d(getBytes(), Nb.e.f5042d) || kotlin.jvm.internal.p.d(getBytes(), Nb.e.f5039a) || kotlin.jvm.internal.p.d(getBytes(), Nb.e.f5040b) || Nb.e.n(this)) {
            return null;
        }
        int iL = Nb.e.l(this);
        if (iL == 2 && q() != null) {
            if (getBytes().K() == 3) {
                return null;
            }
            return new z(ByteString.O(getBytes(), 0, 3, 1, null));
        }
        if (iL == 1 && getBytes().L(Nb.e.f5040b)) {
            return null;
        }
        if (iL != -1 || q() == null) {
            return iL == -1 ? new z(Nb.e.f5042d) : iL == 0 ? new z(ByteString.O(getBytes(), 0, 1, 1, null)) : new z(ByteString.O(getBytes(), 0, iL, 1, null));
        }
        if (getBytes().K() == 2) {
            return null;
        }
        return new z(ByteString.O(getBytes(), 0, 2, 1, null));
    }

    public final z l(z other) {
        kotlin.jvm.internal.p.i(other, "other");
        if (!kotlin.jvm.internal.p.d(c(), other.c())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> listE = e();
        List<ByteString> listE2 = other.e();
        int iMin = Math.min(listE.size(), listE2.size());
        int i10 = 0;
        while (i10 < iMin && kotlin.jvm.internal.p.d(listE.get(i10), listE2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && getBytes().K() == other.getBytes().K()) {
            return Companion.e(INSTANCE, ".", false, 1, null);
        }
        if (listE2.subList(i10, listE2.size()).indexOf(Nb.e.f5043e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (kotlin.jvm.internal.p.d(other.getBytes(), Nb.e.f5042d)) {
            return this;
        }
        C0966d c0966d = new C0966d();
        ByteString byteStringM = Nb.e.m(other);
        if (byteStringM == null && (byteStringM = Nb.e.m(this)) == null) {
            byteStringM = Nb.e.s(f4761c);
        }
        int size = listE2.size();
        for (int i11 = i10; i11 < size; i11++) {
            c0966d.j1(Nb.e.f5043e);
            c0966d.j1(byteStringM);
        }
        int size2 = listE.size();
        while (i10 < size2) {
            c0966d.j1(listE.get(i10));
            c0966d.j1(byteStringM);
            i10++;
        }
        return Nb.e.q(c0966d, false);
    }

    public final z m(z child, boolean normalize) {
        kotlin.jvm.internal.p.i(child, "child");
        return Nb.e.j(this, child, normalize);
    }

    public final z n(String child) {
        kotlin.jvm.internal.p.i(child, "child");
        return Nb.e.j(this, Nb.e.q(new C0966d().L(child), false), false);
    }

    public final Path p() {
        Path path = Paths.get(toString(), new String[0]);
        kotlin.jvm.internal.p.h(path, "get(...)");
        return path;
    }

    public final Character q() {
        if (ByteString.w(getBytes(), Nb.e.f5039a, 0, 2, null) != -1 || getBytes().K() < 2 || getBytes().l(1) != 58) {
            return null;
        }
        char cL = (char) getBytes().l(0);
        if (('a' > cL || cL >= '{') && ('A' > cL || cL >= '[')) {
            return null;
        }
        return Character.valueOf(cL);
    }

    public final File toFile() {
        return new File(toString());
    }

    public String toString() {
        return getBytes().Q();
    }
}
