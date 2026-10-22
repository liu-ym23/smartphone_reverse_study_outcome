package cd9;

import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniProject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wc9.l;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OmniProject f23413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f23414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OmniConversationSortType f23415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23416d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f23413a, r101.f23413a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23414b, r101.f23414b) == true) goto L15;
        return false;
    L15:
        if (this.f23415c == r101.f23415c) goto L18;
        return false;
    L18:
        if (this.f23416d == r101.f23416d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        OmniProject r100 = this.f23413a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<l> r104 = this.f23414b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f23415c.hashCode()) * 31;
        if (this.f23416d == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProjectRecentConversation(project=" + this.f23413a + ", conversationList=" + this.f23414b + ", sortType=" + this.f23415c + ", hasMore=" + this.f23416d + ')';
    }

    public a() {
        this(null, null, OmniConversationSortType.OmniConversationSortType_UPDATE_TIME, false);
    }

    public a(OmniProject r100, List<l> r101, OmniConversationSortType r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "sortType");
        this.f23413a = r100;
        this.f23414b = r101;
        this.f23415c = r102;
        this.f23416d = r103;
    }
}
