package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0018\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0006¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/task/space/A;", "", "<init>", "()V", "", "OFFSET_Y_DP", "F", "SCALE_STEP", "", "LAYER_ALPHA", "[F", Const.INTENT_KEY_APIKEY, "()[F", "THRESHOLD_DP", "FOLLOW_X", "DISMISS_OVERDRAG_X_DP", "UP_TRANSLATION_GAIN_Y", "UP_ROTATION_GAIN", "ROTATE_Z", "ROTATE_Y", "ROTATE_X", "ROTATE_Y_CLAMP_DEG", "ROTATE_X_CLAMP_DEG", "FADE_START_DP", "FADE_DISTANCE_DP", "RECALL_CATCH_UP_DP", "RECALL_OVERDRAG_Y_DP", "RECALL_OVERDRAG_X_DP", "ABOVE_ORIGIN_Y_RATIO", "ABOVE_OFFSCREEN_Y_RATIO", "SPRING_STIFFNESS", "SPRING_DAMPING", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    public static final float ABOVE_OFFSCREEN_Y_RATIO = 1.3f;
    public static final float ABOVE_ORIGIN_Y_RATIO = 0.55f;
    public static final float DISMISS_OVERDRAG_X_DP = 70.0f;
    public static final float FADE_DISTANCE_DP = 150.0f;
    public static final float FADE_START_DP = 40.0f;
    public static final float FOLLOW_X = 0.7f;
    public static final A INSTANCE = new A();
    private static final float[] LAYER_ALPHA = {1.0f, 0.92f, 0.85f};
    public static final float OFFSET_Y_DP = 10.0f;
    public static final float RECALL_CATCH_UP_DP = 130.0f;
    public static final float RECALL_OVERDRAG_X_DP = 48.0f;
    public static final float RECALL_OVERDRAG_Y_DP = 56.0f;
    public static final float ROTATE_X = 0.03f;
    public static final float ROTATE_X_CLAMP_DEG = 12.0f;
    public static final float ROTATE_Y = 0.04f;
    public static final float ROTATE_Y_CLAMP_DEG = 14.0f;
    public static final float ROTATE_Z = 0.05f;
    public static final float SCALE_STEP = 0.05f;
    public static final float SPRING_DAMPING = 0.75f;
    public static final float SPRING_STIFFNESS = 600.0f;
    public static final float THRESHOLD_DP = 80.0f;
    public static final float UP_ROTATION_GAIN = 0.5f;
    public static final float UP_TRANSLATION_GAIN_Y = 1.4f;

    public final float[] a() {
        return LAYER_ALPHA;
    }
}
