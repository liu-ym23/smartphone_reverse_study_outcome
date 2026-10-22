package com.bytedance.android.livesdk.interactivity.api.input;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/InputDialogFragmentSwitchType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "SLIDE_RIGHT", "FADE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputDialogFragmentSwitchType extends Enum<InputDialogFragmentSwitchType> {
    public static final InputDialogFragmentSwitchType FADE = null;
    public static final InputDialogFragmentSwitchType NONE = null;
    public static final InputDialogFragmentSwitchType SLIDE_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputDialogFragmentSwitchType[] f133251a = null;
    private final String typeName;

    static {
        InputDialogFragmentSwitchType r100 = new InputDialogFragmentSwitchType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        InputDialogFragmentSwitchType r101 = new InputDialogFragmentSwitchType("SLIDE_RIGHT", 1, PinchStableView.Gesture.SLIDE_RIGHT);
        SLIDE_RIGHT = r101;
        InputDialogFragmentSwitchType r102 = new InputDialogFragmentSwitchType("FADE", 2, "fade");
        FADE = r102;
        f133251a = new InputDialogFragmentSwitchType[]{r100, r101, r102};
    }

    public static InputDialogFragmentSwitchType valueOf(String r100) {
        return (InputDialogFragmentSwitchType) r27.a.a(InputDialogFragmentSwitchType.class, r100);
    }

    public static InputDialogFragmentSwitchType[] values() {
        return (InputDialogFragmentSwitchType[]) f133251a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public InputDialogFragmentSwitchType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
