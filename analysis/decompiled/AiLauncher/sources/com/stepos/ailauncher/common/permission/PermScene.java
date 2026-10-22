package com.stepos.ailauncher.common.permission;

import Z8.C1172u;
import Z8.C1173v;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermScene;", "", "permissions", "", "", "onceKey", "deniedToastRes", "", "guideTitleRes", "guideMessageRes", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;III)V", "getPermissions", "()Ljava/util/List;", "getOnceKey", "()Ljava/lang/String;", "getDeniedToastRes", "()I", "getGuideTitleRes", "getGuideMessageRes", "MICROPHONE", "NOTIFICATION", "PHONE_STATE", "CAMERA", "MEDIA", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermScene {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PermScene[] $VALUES;
    private final int deniedToastRes;
    private final int guideMessageRes;
    private final int guideTitleRes;
    private final String onceKey;
    private final List<String> permissions;
    public static final PermScene MICROPHONE = new PermScene("MICROPHONE", 0, C1172u.e(PolicySdkPermissionManifestUtils.RECORD_AUDIO), "perm_asked_microphone", R$string.perm_denied_microphone, R$string.perm_guide_title_microphone, R$string.perm_guide_message_microphone);
    public static final PermScene NOTIFICATION = new PermScene("NOTIFICATION", 1, C1172u.e("android.permission.POST_NOTIFICATIONS"), "perm_asked_notification", R$string.perm_denied_notification, R$string.perm_guide_title_notification, R$string.perm_guide_message_notification);
    public static final PermScene PHONE_STATE = new PermScene("PHONE_STATE", 2, C1172u.e(PolicySdkPermissionManifestUtils.READ_PHONE_STATE), "perm_asked_phone_state", R$string.perm_denied_phone_state, R$string.perm_guide_title_phone_state, R$string.perm_guide_message_phone_state);
    public static final PermScene CAMERA = new PermScene("CAMERA", 3, C1172u.e("android.permission.CAMERA"), "perm_asked_camera", R$string.perm_denied_camera, R$string.perm_guide_title_carema, R$string.perm_guide_message_camera);
    public static final PermScene MEDIA = new PermScene("MEDIA", 4, C1173v.p(PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO), "perm_asked_media", R$string.perm_denied_media, R$string.perm_guide_title_media, R$string.perm_guide_message_media);

    private static final /* synthetic */ PermScene[] $values() {
        return new PermScene[]{MICROPHONE, NOTIFICATION, PHONE_STATE, CAMERA, MEDIA};
    }

    static {
        PermScene[] permSceneArr$values = $values();
        $VALUES = permSceneArr$values;
        $ENTRIES = kotlin.enums.a.a(permSceneArr$values);
    }

    private PermScene(String str, int i10, List list, String str2, int i11, int i12, int i13) {
        this.permissions = list;
        this.onceKey = str2;
        this.deniedToastRes = i11;
        this.guideTitleRes = i12;
        this.guideMessageRes = i13;
    }

    public static InterfaceC4149a<PermScene> getEntries() {
        return $ENTRIES;
    }

    public static PermScene valueOf(String str) {
        return (PermScene) Enum.valueOf(PermScene.class, str);
    }

    public static PermScene[] values() {
        return (PermScene[]) $VALUES.clone();
    }

    public final int getDeniedToastRes() {
        return this.deniedToastRes;
    }

    public final int getGuideMessageRes() {
        return this.guideMessageRes;
    }

    public final int getGuideTitleRes() {
        return this.guideTitleRes;
    }

    public final String getOnceKey() {
        return this.onceKey;
    }

    public final List<String> getPermissions() {
        return this.permissions;
    }
}
