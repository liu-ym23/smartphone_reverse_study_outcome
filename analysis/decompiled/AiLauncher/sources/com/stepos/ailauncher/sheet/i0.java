package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetSpring;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\bR\u0017\u0010 \u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\bR\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0006R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0006R\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\bR\u0014\u0010'\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u000bR\u0017\u0010(\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\bR\u0017\u0010*\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\bR\u0017\u0010,\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\bR\u0017\u0010.\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\bR\u0014\u00100\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\u000bR\u0014\u00101\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010\u000bR\u0014\u00102\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\u000bR\u0014\u00103\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010\u000bR\u0014\u00104\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\u000bR\u0017\u00105\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u0010\bR\u0017\u00107\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\bR\u0017\u00109\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\u0006\u001a\u0004\b:\u0010\bR\u0017\u0010;\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\bR\u0017\u0010=\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\u0006\u001a\u0004\b>\u0010\bR\u0014\u0010?\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010\u000bR\u0017\u0010@\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\bA\u0010\u0012R\u0017\u0010C\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010G\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bG\u0010\u0006\u001a\u0004\bH\u0010\bR\u0017\u0010I\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\u0006\u001a\u0004\bJ\u0010\bR\u0017\u0010K\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bK\u0010\u0006\u001a\u0004\bL\u0010\bR\u0017\u0010M\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bM\u0010\u0006\u001a\u0004\bN\u0010\bR\u0017\u0010O\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bO\u0010\u0006\u001a\u0004\bP\u0010\bR\u0017\u0010Q\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\bR\u0017\u0010S\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bS\u0010\u0006\u001a\u0004\bT\u0010\bR\u0014\u0010U\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010\u000bR\u0014\u0010V\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010\u000bR\u0014\u0010W\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010\u000bR\u0014\u0010X\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010\u000bR\u0014\u0010Y\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010\u000bR\u0014\u0010[\u001a\u00020Z8\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006]"}, d2 = {"Lcom/stepos/ailauncher/sheet/i0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/g0;", "HOME_GROUP_EXIT", "Lcom/stepos/ailauncher/sheet/g0;", "v", "()Lcom/stepos/ailauncher/sheet/g0;", "", "HOME_GROUP_EXIT_POSITION_END", "F", "ALL_TASKS_RISE", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/sheet/f0;", "CHAT_LONG_PRESS_ENTER", "Lcom/stepos/ailauncher/sheet/f0;", "getCHAT_LONG_PRESS_ENTER", "()Lcom/stepos/ailauncher/sheet/f0;", "CHAT_EXIT_FULL_WIDTH", "p", "CHAT_EXIT_FULL_HEIGHT", "getCHAT_EXIT_FULL_HEIGHT", "CHAT_EXIT_FULL_OFFSET", "o", "CHAT_EXIT", "n", "CHAT_EXIT_FULL_OFFSET_DAMPING_RATIO", "CHAT_EXIT_FULL_BAR_EXTRA_DP", "CHAT_EXIT_FULL_BAR_OVERLAY_EXTRA_DP", "CHAT_EXIT_COLOR", "getCHAT_EXIT_COLOR", "CHAT_EXIT_RADIUS", "q", "CHAT_ENTER_WIDTH", "CHAT_ENTER_HEIGHT", "CHAT_ENTER_OFFSET", "CHAT_ENTER_COLOR", Const.INTENT_KEY_UMID, "CHAT_ENTER_HALF_TEMPO", "CHAT_ENTER_HALF_WIDTH", "l", "CHAT_ENTER_HALF_HEIGHT", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "CHAT_ENTER_HALF_OFFSET", "k", "CHAT_ENTER_RADIUS", "m", "CHAT_ENTER_POSITION_VELOCITY_DP", "CHAT_ENTER_HALF_POSITION_VELOCITY_DP", "CHAT_ENTER_HALF_REBOUND_DAMPING_RATIO", "CHAT_ENTER_FULL_TEMPO", "CHAT_ENTER_FULL_REBOUND_DAMPING_RATIO", "CHAT_ENTER_FULL_WIDTH", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "CHAT_ENTER_FULL_HEIGHT", "f", "CHAT_ENTER_FULL_OFFSET", Const.INTENT_KEY_BACKGROUND_COMMAND, "CHAT_ENTER_FULL_COLOR", "e", "CHAT_ENTER_FULL_RADIUS", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "CHAT_ENTER_FULL_POSITION_VELOCITY_DP", "CHAT_LONG_PRESS_ENTER_FULL", "r", "Lcom/stepos/ailauncher/sheet/e0;", "STACKED_PANEL", "Lcom/stepos/ailauncher/sheet/e0;", "w", "()Lcom/stepos/ailauncher/sheet/e0;", "STACK_BACKGROUND_TRANSFORM", "x", "STACK_DEEP_ALPHA", "y", "CHAT_PAGER_TO_SESSION_CENTER", "t", "CHAT_PAGER_TO_CHAT", "s", "CARD_SLIDE_IN", "c", "CARD_FADE_IN", Const.INTENT_KEY_PKGNAME, "DRAG_HANDLE_ALPHA", "u", "DRAG_HANDLE_REST_ALPHA", "DESIGN_CANVAS_WIDTH_PX", "STACK_BACKGROUND_LIFT_PX", "STACK_BACKGROUND_SCALE", "STACK_BACKGROUND_ALPHA", "", "STACK_BACKGROUND_RGB", "I", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i0 {
    private static final SheetSpring ALL_TASKS_RISE;
    private static final SheetSpring CARD_FADE_IN;
    private static final SheetSpring CARD_SLIDE_IN;
    private static final SheetSpring CHAT_ENTER_COLOR;
    private static final SheetSpring CHAT_ENTER_FULL_COLOR;
    private static final SheetSpring CHAT_ENTER_FULL_HEIGHT;
    private static final SheetSpring CHAT_ENTER_FULL_OFFSET;
    public static final float CHAT_ENTER_FULL_POSITION_VELOCITY_DP = 2.5f;
    private static final SheetSpring CHAT_ENTER_FULL_RADIUS;
    public static final float CHAT_ENTER_FULL_REBOUND_DAMPING_RATIO = 0.78f;
    public static final float CHAT_ENTER_FULL_TEMPO = 1.25f;
    private static final SheetSpring CHAT_ENTER_FULL_WIDTH;
    private static final SheetSpring CHAT_ENTER_HALF_HEIGHT;
    private static final SheetSpring CHAT_ENTER_HALF_OFFSET;
    public static final float CHAT_ENTER_HALF_POSITION_VELOCITY_DP = 2.5f;
    public static final float CHAT_ENTER_HALF_REBOUND_DAMPING_RATIO = 0.78f;
    public static final float CHAT_ENTER_HALF_TEMPO = 1.25f;
    private static final SheetSpring CHAT_ENTER_HALF_WIDTH;
    private static final SheetSpring CHAT_ENTER_HEIGHT;
    private static final SheetSpring CHAT_ENTER_OFFSET;
    public static final float CHAT_ENTER_POSITION_VELOCITY_DP = 2.0f;
    private static final SheetSpring CHAT_ENTER_RADIUS;
    private static final SheetSpring CHAT_ENTER_WIDTH;
    private static final SheetScaleMotion CHAT_EXIT;
    private static final SheetSpring CHAT_EXIT_COLOR;
    public static final float CHAT_EXIT_FULL_BAR_EXTRA_DP = 0.85f;
    public static final float CHAT_EXIT_FULL_BAR_OVERLAY_EXTRA_DP = 0.3f;
    private static final SheetSpring CHAT_EXIT_FULL_HEIGHT;
    private static final SheetSpring CHAT_EXIT_FULL_OFFSET;
    public static final float CHAT_EXIT_FULL_OFFSET_DAMPING_RATIO = 0.89f;
    private static final SheetSpring CHAT_EXIT_FULL_WIDTH;
    private static final SheetSpring CHAT_EXIT_RADIUS;
    private static final SheetScaleMotion CHAT_LONG_PRESS_ENTER;
    private static final SheetScaleMotion CHAT_LONG_PRESS_ENTER_FULL;
    private static final SheetSpring CHAT_PAGER_TO_CHAT;
    private static final SheetSpring CHAT_PAGER_TO_SESSION_CENTER;
    public static final float DESIGN_CANVAS_WIDTH_PX = 1176.0f;
    private static final SheetSpring DRAG_HANDLE_ALPHA;
    public static final float DRAG_HANDLE_REST_ALPHA = 0.34f;
    public static final float HOME_GROUP_EXIT_POSITION_END = 871.0f;
    private static final SheetOffsetMotion STACKED_PANEL;
    public static final float STACK_BACKGROUND_ALPHA = 0.9019608f;
    public static final float STACK_BACKGROUND_LIFT_PX = 40.09f;
    public static final int STACK_BACKGROUND_RGB = 2105376;
    public static final float STACK_BACKGROUND_SCALE = 0.95f;
    private static final SheetSpring STACK_BACKGROUND_TRANSFORM;
    private static final SheetSpring STACK_DEEP_ALPHA;
    public static final i0 INSTANCE = new i0();
    private static final SheetSpring HOME_GROUP_EXIT = new SheetSpring(450.0f, 1.0f);

    static {
        SheetSpring.Companion companion = SheetSpring.INSTANCE;
        ALL_TASKS_RISE = SheetSpring.Companion.b(companion, 140.0f, 19.0f, 0.0f, 4, null);
        SheetScaleMotion sheetScaleMotion = new SheetScaleMotion(SheetSpring.Companion.b(companion, 120.0f, 18.62f, 0.0f, 4, null), SheetSpring.Companion.b(companion, 400.0f, 40.0f, 0.0f, 4, null), 0.2f, 1.2911565f, 0.0f, 16, null);
        CHAT_LONG_PRESS_ENTER = sheetScaleMotion;
        SheetSpring sheetSpring = new SheetSpring(120.0f, 0.46f);
        CHAT_EXIT_FULL_WIDTH = sheetSpring;
        SheetSpring sheetSpring2 = new SheetSpring(230.0f, 0.89f);
        CHAT_EXIT_FULL_HEIGHT = sheetSpring2;
        CHAT_EXIT_FULL_OFFSET = sheetSpring2;
        CHAT_EXIT = new SheetScaleMotion(sheetSpring2, sheetSpring, 0.0952381f, 0.7808844f, 0.0f, 16, null);
        SheetSpring sheetSpringB = SheetSpring.Companion.b(companion, 80.0f, 16.15f, 0.0f, 4, null);
        CHAT_EXIT_COLOR = sheetSpringB;
        CHAT_EXIT_RADIUS = sheetSpringB;
        SheetSpring sheetSpringB2 = SheetSpring.Companion.b(companion, 280.0f, 30.0f, 0.0f, 4, null);
        CHAT_ENTER_WIDTH = sheetSpringB2;
        SheetSpring sheetSpringB3 = SheetSpring.Companion.b(companion, 160.0f, 18.0f, 0.0f, 4, null);
        CHAT_ENTER_HEIGHT = sheetSpringB3;
        SheetSpring sheetSpringB4 = SheetSpring.Companion.b(companion, 140.0f, 19.0f, 0.0f, 4, null);
        CHAT_ENTER_OFFSET = sheetSpringB4;
        SheetSpring sheetSpringB5 = SheetSpring.Companion.b(companion, 600.0f, 42.24f, 0.0f, 4, null);
        CHAT_ENTER_COLOR = sheetSpringB5;
        SheetSpring sheetSpringF = SheetSpring.f(sheetSpringB2, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_HALF_WIDTH = sheetSpringF;
        CHAT_ENTER_HALF_HEIGHT = SheetSpring.f(sheetSpringB3, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_HALF_OFFSET = SheetSpring.f(sheetSpringB4, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_RADIUS = sheetSpringF;
        SheetSpring sheetSpringF2 = SheetSpring.f(sheetSpringB2, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_FULL_WIDTH = sheetSpringF2;
        CHAT_ENTER_FULL_HEIGHT = SheetSpring.f(sheetSpringB3, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_FULL_OFFSET = SheetSpring.f(sheetSpringB4, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_FULL_COLOR = SheetSpring.f(sheetSpringB5, 1.25f, 0.0f, 2, null);
        CHAT_ENTER_FULL_RADIUS = sheetSpringF2;
        CHAT_LONG_PRESS_ENTER_FULL = new SheetScaleMotion(sheetScaleMotion.getOffset().e(1.25f, 0.78f), SheetSpring.f(sheetScaleMotion.getScale(), 1.25f, 0.0f, 2, null), sheetScaleMotion.getCollapsedScale(), sheetScaleMotion.getTravelWidthFraction(), 0.0f, 16, null);
        STACKED_PANEL = new SheetOffsetMotion(SheetSpring.Companion.b(companion, 220.0f, 24.0f, 0.0f, 4, null), 2.0964031f);
        STACK_BACKGROUND_TRANSFORM = SheetSpring.Companion.b(companion, 120.0f, 16.0f, 0.0f, 4, null);
        SheetSpring sheetSpringB6 = SheetSpring.Companion.b(companion, 400.0f, 40.0f, 0.0f, 4, null);
        STACK_DEEP_ALPHA = sheetSpringB6;
        CHAT_PAGER_TO_SESSION_CENTER = SheetSpring.Companion.b(companion, 318.0f, 30.0f, 0.0f, 4, null);
        CHAT_PAGER_TO_CHAT = SheetSpring.Companion.b(companion, 318.0f, 30.0f, 0.0f, 4, null);
        CARD_SLIDE_IN = SheetSpring.b(SheetSpring.Companion.b(companion, 200.0f, 20.0f, 0.0f, 4, null), 0.0f, 0.8f, 1, null);
        CARD_FADE_IN = sheetSpringB6;
        DRAG_HANDLE_ALPHA = sheetSpringB6;
    }

    public final SheetSpring a() {
        return ALL_TASKS_RISE;
    }

    public final SheetSpring b() {
        return CARD_FADE_IN;
    }

    public final SheetSpring c() {
        return CARD_SLIDE_IN;
    }

    public final SheetSpring d() {
        return CHAT_ENTER_COLOR;
    }

    public final SheetSpring e() {
        return CHAT_ENTER_FULL_COLOR;
    }

    public final SheetSpring f() {
        return CHAT_ENTER_FULL_HEIGHT;
    }

    public final SheetSpring g() {
        return CHAT_ENTER_FULL_OFFSET;
    }

    public final SheetSpring h() {
        return CHAT_ENTER_FULL_RADIUS;
    }

    public final SheetSpring i() {
        return CHAT_ENTER_FULL_WIDTH;
    }

    public final SheetSpring j() {
        return CHAT_ENTER_HALF_HEIGHT;
    }

    public final SheetSpring k() {
        return CHAT_ENTER_HALF_OFFSET;
    }

    public final SheetSpring l() {
        return CHAT_ENTER_HALF_WIDTH;
    }

    public final SheetSpring m() {
        return CHAT_ENTER_RADIUS;
    }

    public final SheetScaleMotion n() {
        return CHAT_EXIT;
    }

    public final SheetSpring o() {
        return CHAT_EXIT_FULL_OFFSET;
    }

    public final SheetSpring p() {
        return CHAT_EXIT_FULL_WIDTH;
    }

    public final SheetSpring q() {
        return CHAT_EXIT_RADIUS;
    }

    public final SheetScaleMotion r() {
        return CHAT_LONG_PRESS_ENTER_FULL;
    }

    public final SheetSpring s() {
        return CHAT_PAGER_TO_CHAT;
    }

    public final SheetSpring t() {
        return CHAT_PAGER_TO_SESSION_CENTER;
    }

    public final SheetSpring u() {
        return DRAG_HANDLE_ALPHA;
    }

    public final SheetSpring v() {
        return HOME_GROUP_EXIT;
    }

    public final SheetOffsetMotion w() {
        return STACKED_PANEL;
    }

    public final SheetSpring x() {
        return STACK_BACKGROUND_TRANSFORM;
    }

    public final SheetSpring y() {
        return STACK_DEEP_ALPHA;
    }
}
