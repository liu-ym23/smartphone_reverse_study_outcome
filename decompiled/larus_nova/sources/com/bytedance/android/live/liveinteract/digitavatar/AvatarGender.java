package com.bytedance.android.live.liveinteract.digitavatar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/AvatarGender;", "", "", "getStickId", "Male", "Female", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract enum AvatarGender extends Enum<AvatarGender> {

    @SerializedName("Female")
    public static final AvatarGender Female = null;

    @SerializedName("Male")
    public static final AvatarGender Male = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarGender[] f72522a = null;

    static {
        final String r100 = "Male";
        final int r101 = 0;
        AvatarGender r102 = new Male(r100, r101);
        Male = r102;
        final String r103 = "Female";
        final int r104 = 1;
        AvatarGender r105 = new Female(r103, r104);
        Female = r105;
        f72522a = new AvatarGender[]{r102, r105};
    }

    public AvatarGender() {
        throw null;
    }

    public static AvatarGender valueOf(String r100) {
        return (AvatarGender) r27.a.a(AvatarGender.class, r100);
    }

    public static AvatarGender[] values() {
        return (AvatarGender[]) f72522a.clone();
    }

    public abstract String getStickId();

    public AvatarGender(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
