package com.bytedance.android.livesdk.interactivity.api.entity;

import com.larus.media.MediaScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/entity/PSMessageAction;", "", "", "serverValue", "I", "getServerValue", "()I", "CHAT", "BUSINESS", "BASIC", MediaScene.SYSTEM, "UNKNOW", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessageAction extends Enum<PSMessageAction> {
    public static final PSMessageAction BASIC = null;
    public static final PSMessageAction BUSINESS = null;
    public static final PSMessageAction CHAT = null;
    public static final PSMessageAction SYSTEM = null;
    public static final PSMessageAction UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSMessageAction[] f133129a = null;
    private final int serverValue;

    static {
        PSMessageAction r100 = new PSMessageAction("CHAT", 0, 1);
        CHAT = r100;
        PSMessageAction r101 = new PSMessageAction("BUSINESS", 1, 3);
        BUSINESS = r101;
        PSMessageAction r102 = new PSMessageAction("BASIC", 2, 2);
        BASIC = r102;
        PSMessageAction r103 = new PSMessageAction(MediaScene.SYSTEM, 3, 4);
        SYSTEM = r103;
        PSMessageAction r104 = new PSMessageAction("UNKNOW", 4, 0);
        UNKNOW = r104;
        f133129a = new PSMessageAction[]{r100, r101, r102, r103, r104};
    }

    public static PSMessageAction valueOf(String r100) {
        return (PSMessageAction) r27.a.a(PSMessageAction.class, r100);
    }

    public static PSMessageAction[] values() {
        return (PSMessageAction[]) f133129a.clone();
    }

    public final int getServerValue() {
        return this.serverValue;
    }

    public PSMessageAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.serverValue = r102;
    }
}
