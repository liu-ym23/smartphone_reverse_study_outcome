package ccb;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ChatChatter> f23335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f23336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f23337g;

    public a() {
        this(0, false, false, "", new ArrayList(0), null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f23331a == r101.f23331a) goto L12;
        return false;
    L12:
        if (this.f23332b == r101.f23332b) goto L15;
        return false;
    L15:
        if (this.f23333c == r101.f23333c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23334d, r101.f23334d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f23335e, r101.f23335e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f23336f, r101.f23336f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f23337g, r101.f23337g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f23331a * 31;
        int r101 = 1231;
        if (this.f23332b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f23333c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        String r105 = this.f23334d;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r104 + r107) * 31) + this.f23335e.hashCode()) * 31;
        Map<String, String> r109 = this.f23336f;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Map<String, String> r112 = this.f23337g;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatChatterResponse(memberCount=" + this.f23331a + ", showSearch=" + this.f23332b + ", isShowDepartment=" + this.f23333c + ", cursor=" + this.f23334d + ", chatChatters=" + this.f23335e + ", chatterLetterMap=" + this.f23336f + ", chatterDepartmentNameMap=" + this.f23337g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, boolean r101, boolean r102, String r103, List<? extends ChatChatter> r104, Map<String, String> r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r104, "chatChatters");
        this.f23331a = r100;
        this.f23332b = r101;
        this.f23333c = r102;
        this.f23334d = r103;
        this.f23335e = r104;
        this.f23336f = r105;
        this.f23337g = r106;
    }
}
