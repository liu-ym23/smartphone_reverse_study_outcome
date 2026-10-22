package ab8;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.platform.api.creation.UserCreation;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "", "id", "", EventConstant.Key.RETAIN_PROMPT, "", "imageThumb", "Lcom/larus/bmhome/actionbar/model/Icon;", "imageOri", "imagePreview", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(JLjava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/bmhome/actionbar/model/Icon;Lcom/larus/platform/api/creation/UserCreation;)V", "getId", "()J", "getPrompt", "()Ljava/lang/String;", "getImageThumb", "()Lcom/larus/bmhome/actionbar/model/Icon;", "getImageOri", "getImagePreview", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserCreation f2499a;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private final long f2500id;

    @SerializedName("ori")
    private final g1 imageOri;

    @SerializedName("preview")
    private final g1 imagePreview;

    @SerializedName("thumb")
    private final g1 imageThumb;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private final String prompt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f2500id == r101.f2500id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prompt, r101.prompt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imagePreview, r101.imagePreview) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f2499a, r101.f2499a) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f2500id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.prompt;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        g1 r106 = this.imageThumb;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        g1 r109 = this.imageOri;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        g1 r112 = this.imagePreview;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        UserCreation r115 = this.f2499a;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return r114 + r103;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "DigitalAvatarTemplate(id=" + this.f2500id + ", prompt=" + this.prompt + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", imagePreview=" + this.imagePreview + ", userCreation=" + this.f2499a + ')';
    }

    public a() {
        this(0, "", null, null, null, null);
    }

    public final long a() {
        return this.f2500id;
    }

    public final g1 b() {
        return this.imageOri;
    }

    public final g1 c() {
        return this.imagePreview;
    }

    public final g1 d() {
        return this.imageThumb;
    }

    public final String e() {
        return this.prompt;
    }

    public a(long r100, String r101, g1 r102, g1 r103, g1 r104, UserCreation r105) {
        this.f2500id = r100;
        this.prompt = r101;
        this.imageThumb = r102;
        this.imageOri = r103;
        this.imagePreview = r104;
        this.f2499a = r105;
    }
}
