package a3a;

import com.larus.audio.call.mgr.MajorState;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pf9.p;

/* JADX INFO: loaded from: classes32.dex */
public interface a {

    /* JADX INFO: renamed from: a3a.a$a, reason: collision with other inner class name */
    public static final class C0009a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f1683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f1685c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0009a) == true) goto L8;
            return false;
        L8:
            C0009a r101 = (C0009a) r100;
            if (Intrinsics.areEqual(this.f1683a, r101.f1683a) == true) goto L12;
            return false;
        L12:
            if (this.f1684b == r101.f1684b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f1685c, r101.f1685c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((Arrays.hashCode(this.f1683a) * 31) + this.f1684b) * 31;
            Long r101 = this.f1685c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "AudioDataReceive(data=" + Arrays.toString(this.f1683a) + ", readSize=" + this.f1684b + ", audioTimeNs=" + this.f1685c + ')';
        }

        public C0009a(byte[] r100, int r101, Long r102) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f1683a = r100;
            this.f1684b = r101;
            this.f1685c = r102;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<p> f1686a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f1686a, ((b) r100).f1686a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f1686a.hashCode();
        }

        public final String toString() {
            return "CommandReply(commands=" + this.f1686a + ')';
        }

        public b(List<p> r100) {
            Intrinsics.checkNotNullParameter(r100, "commands");
            this.f1686a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1687a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f1687a, ((c) r100).f1687a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f1687a.hashCode();
        }

        public final String toString() {
            return "ConversationIdUpdated(conversationId=" + this.f1687a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f1687a = r100;
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Integer f1688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f1689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1690c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f1691d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f1688a, r101.f1688a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1689b, r101.f1689b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f1690c, r101.f1690c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f1691d, r101.f1691d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f1688a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f1689b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((r103 + r105) * 31) + this.f1690c.hashCode()) * 31;
            Integer r107 = this.f1691d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Error(errorCode=" + this.f1688a + ", vuiErrorCode=" + this.f1689b + ", message=" + this.f1690c + ", subErrorCode=" + this.f1691d + ')';
        }

        public d(Integer r100, Integer r101, String r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r102, "message");
            this.f1688a = r100;
            this.f1689b = r101;
            this.f1690c = r102;
            this.f1691d = r103;
        }
    }

    public static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MajorState f1692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MajorState f1693b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f1692a, r101.f1692a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1693b, r101.f1693b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f1692a.hashCode() * 31) + this.f1693b.hashCode();
        }

        public final String toString() {
            return "MajorStateChanged(previous=" + this.f1692a + ", current=" + this.f1693b + ')';
        }

        public e(MajorState r100, MajorState r101) {
            Intrinsics.checkNotNullParameter(r100, "previous");
            Intrinsics.checkNotNullParameter(r101, "current");
            this.f1692a = r100;
            this.f1693b = r101;
        }
    }

    public static final class f implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1694a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f1694a, ((f) r100).f1694a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f1694a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "QueryBegin(asrTaskId=" + this.f1694a + ')';
        }

        public f(String r100) {
            this.f1694a = r100;
        }
    }

    public static final class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1695a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f1695a == ((g) r100).f1695a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f1695a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.f1695a + ')';
        }

        public g(boolean r100) {
            this.f1695a = r100;
        }
    }

    public static final class h implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pf9.a f1696a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f1696a, ((h) r100).f1696a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            pf9.a r100 = this.f1696a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "QueryUpdate(asrResult=" + this.f1696a + ')';
        }

        public h(pf9.a r100) {
            this.f1696a = r100;
        }
    }

    public static final class i implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f1697a = null;

        static {
            f1697a = new i();
        }

        public i() {
        }
    }

    public static final class j implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f1698a = null;

        static {
            f1698a = new j();
        }

        public j() {
        }
    }

    public static final class k implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f1699a = null;

        static {
            f1699a = new k();
        }

        public k() {
        }
    }

    public static final class l implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f1702c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (this.f1700a == r101.f1700a) goto L12;
            return false;
        L12:
            if (this.f1701b == r101.f1701b) goto L15;
            return false;
        L15:
            if (this.f1702c == r101.f1702c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f1700a * 31) + this.f1701b) * 31;
            if (this.f1702c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "StateChanged(previous=" + this.f1700a + ", current=" + this.f1701b + ", firstConnect=" + this.f1702c + ')';
        }

        public l(int r100, int r101, boolean r102) {
            this.f1700a = r100;
            this.f1701b = r101;
            this.f1702c = r102;
        }
    }
}
