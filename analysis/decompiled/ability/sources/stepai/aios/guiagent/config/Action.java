package stepai.aios.guiagent.config;

import W7.c;
import Y7.f;
import androidx.autofill.HintConstants;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import g1.AbstractC1451a;
import j9.m;
import j9.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import stepai.aios.guiagent.config.ValidationResult;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u001bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0013\u0010$\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0010R\u0011\u0010&\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b'\u0010\u0018R\u0013\u0010(\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b)\u0010\u0010R\u0013\u0010*\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0010¨\u00069"}, d2 = {"Lstepai/aios/guiagent/config/Action;", "", "id", "", "type", "Lstepai/aios/guiagent/config/ActionType;", "parameters", "", "state", "Lstepai/aios/guiagent/config/ActionState;", "timestamp", "", "errorMessage", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lstepai/aios/guiagent/config/ActionType;Ljava/util/Map;Lstepai/aios/guiagent/config/ActionState;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "()Lstepai/aios/guiagent/config/ActionType;", "getParameters", "()Ljava/util/Map;", "getState", "()Lstepai/aios/guiagent/config/ActionState;", "getTimestamp", "()J", "getErrorMessage", "x", "", "getX", "()I", "y", "getY", "endX", "getEndX", "endY", "getEndY", "text", "getText", TypedValues.TransitionType.S_DURATION, "getDuration", "packageName", "getPackageName", "message", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Action {
    private static final int MAX_COORDINATE = 10000;
    private static final long MAX_DURATION_MS = 300000;
    private static final int MAX_MESSAGE_LENGTH = 1000;
    private static final int MAX_TEXT_LENGTH = 10000;
    private final String errorMessage;
    private final String id;
    private final Map<String, Object> parameters;
    private final ActionState state;
    private final long timestamp;
    private final ActionType type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex PACKAGE_NAME_REGEX = new Regex("^[a-zA-Z][a-zA-Z0-9_]*(?:\\.[a-zA-Z][a-zA-Z0-9_]*)*$");

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0012¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010)J\r\u0010,\u001a\u00020\u001a¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u001a¢\u0006\u0004\b.\u0010-J\u0019\u0010/\u001a\u00020\u001a2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b/\u0010)J\u0015\u00102\u001a\u0002012\u0006\u00100\u001a\u00020\u001a¢\u0006\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00105R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00105R\u0014\u00108\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006="}, d2 = {"Lstepai/aios/guiagent/config/Action$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "value", "", HintConstants.AUTOFILL_HINT_NAME, "LC7/r;", "validateCoordinate", "(ILjava/lang/String;)V", "text", "maxLength", "validateText", "(Ljava/lang/String;ILjava/lang/String;)V", "packageName", "validatePackageName", "(Ljava/lang/String;)V", "", TypedValues.TransitionType.S_DURATION, "validateDuration", "(J)V", "generateId", "()Ljava/lang/String;", "x", "y", "Lstepai/aios/guiagent/config/Action;", "createClick", "(II)Lstepai/aios/guiagent/config/Action;", "createType", "(Ljava/lang/String;II)Lstepai/aios/guiagent/config/Action;", "startX", "startY", "endX", "endY", "createSwipe", "(IIII)Lstepai/aios/guiagent/config/Action;", "durationMs", "createWait", "(J)Lstepai/aios/guiagent/config/Action;", "createAwake", "(Ljava/lang/String;)Lstepai/aios/guiagent/config/Action;", "message", "createInquiry", "createComplete", "()Lstepai/aios/guiagent/config/Action;", "createAbort", "createTakeover", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lstepai/aios/guiagent/config/ValidationResult;", "validateAction", "(Lstepai/aios/guiagent/config/Action;)Lstepai/aios/guiagent/config/ValidationResult;", "MAX_COORDINATE", "I", "MAX_TEXT_LENGTH", "MAX_MESSAGE_LENGTH", "MAX_DURATION_MS", "J", "Lkotlin/text/Regex;", "PACKAGE_NAME_REGEX", "Lkotlin/text/Regex;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ActionType.values().length];
                try {
                    iArr[ActionType.CLICK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ActionType.TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ActionType.SWIPE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ActionType.WAIT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ActionType.AWAKE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ActionType.INQUIRY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ActionType.COMPLETE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ActionType.ABORT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ActionType.TAKEOVER.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ActionType.BACK.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ActionType.HOME.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ActionType.ENTER.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ Action createTakeover$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.createTakeover(str);
        }

        public static /* synthetic */ Action createType$default(Companion companion, String str, int i, int i6, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                i = 0;
            }
            if ((i10 & 4) != 0) {
                i6 = 0;
            }
            return companion.createType(str, i, i6);
        }

        private final String generateId() {
            return "action_" + System.currentTimeMillis() + "_" + AbstractC1451a.R(c.f1492a, new f(0, 999, 1));
        }

        private final void validateCoordinate(int value, String name) {
            if (value < 0) {
                throw new IllegalArgumentException((name + " must be non-negative: " + value).toString());
            }
            if (value <= 10000) {
                return;
            }
            throw new IllegalArgumentException((name + " too large: " + value + " (max: 10000)").toString());
        }

        private final void validateDuration(long duration) {
            if (duration < 0) {
                throw new IllegalArgumentException(b.p(duration, "Duration must be non-negative: ").toString());
            }
            if (duration > 300000) {
                throw new IllegalArgumentException(b.q(duration, "Duration too long: ", " > 300000").toString());
            }
        }

        private final void validatePackageName(String packageName) {
            if (packageName != null) {
                if (m.s0(packageName)) {
                    throw new IllegalArgumentException("Package name cannot be blank");
                }
                if (!Action.PACKAGE_NAME_REGEX.d(packageName)) {
                    throw new IllegalArgumentException("Invalid package name format: ".concat(packageName).toString());
                }
            }
        }

        private final void validateText(String text, int maxLength, String name) {
            if (text == null || text.length() <= maxLength) {
                return;
            }
            throw new IllegalArgumentException((name + " too long: " + text.length() + " > " + maxLength).toString());
        }

        public final Action createAbort() {
            return new Action(generateId(), ActionType.ABORT, a.M(), null, 0L, null, 56, null);
        }

        public final Action createAwake(String packageName) {
            k.f(packageName, "packageName");
            if (m.s0(packageName)) {
                throw new IllegalArgumentException("Package name cannot be blank");
            }
            validatePackageName(packageName);
            return new Action(generateId(), ActionType.AWAKE, B7.a.x("packageName", packageName), null, 0L, null, 56, null);
        }

        public final Action createClick(int x10, int y) {
            validateCoordinate(x10, "X coordinate");
            validateCoordinate(y, "Y coordinate");
            return new Action(generateId(), ActionType.CLICK, a.R(new Pair("x", Integer.valueOf(x10)), new Pair("y", Integer.valueOf(y))), null, 0L, null, 56, null);
        }

        public final Action createComplete() {
            return new Action(generateId(), ActionType.COMPLETE, a.M(), null, 0L, null, 56, null);
        }

        public final Action createInquiry(String message) {
            k.f(message, "message");
            if (m.s0(message)) {
                throw new IllegalArgumentException("Message cannot be blank");
            }
            validateText(message, 1000, "Message");
            return new Action(generateId(), ActionType.INQUIRY, B7.a.x("message", message), null, 0L, null, 56, null);
        }

        public final Action createSwipe(int startX, int startY, int endX, int endY) {
            validateCoordinate(startX, "Start X coordinate");
            validateCoordinate(startY, "Start Y coordinate");
            validateCoordinate(endX, "End X coordinate");
            validateCoordinate(endY, "End Y coordinate");
            if (startX == endX && startY == endY) {
                throw new IllegalArgumentException("Swipe start and end points cannot be the same");
            }
            return new Action(generateId(), ActionType.SWIPE, a.R(new Pair("x", Integer.valueOf(startX)), new Pair("y", Integer.valueOf(startY)), new Pair("endX", Integer.valueOf(endX)), new Pair("endY", Integer.valueOf(endY))), null, 0L, null, 56, null);
        }

        public final Action createTakeover(String message) {
            Map mapM;
            if (message == null || m.s0(message)) {
                mapM = a.M();
            } else {
                validateText(message, 1000, "Message");
                mapM = B7.a.x("message", message);
            }
            return new Action(generateId(), ActionType.TAKEOVER, mapM, null, 0L, null, 56, null);
        }

        public final Action createType(String text, int x10, int y) {
            k.f(text, "text");
            if (m.s0(text)) {
                throw new IllegalArgumentException("Text cannot be blank");
            }
            validateText(text, 10000, "Text");
            validateCoordinate(x10, "X coordinate");
            validateCoordinate(y, "Y coordinate");
            return new Action(generateId(), ActionType.TYPE, a.R(new Pair("text", text), new Pair("x", Integer.valueOf(x10)), new Pair("y", Integer.valueOf(y))), null, 0L, null, 56, null);
        }

        public final Action createWait(long durationMs) {
            validateDuration(durationMs);
            return new Action(generateId(), ActionType.WAIT, a.Q(new Pair(TypedValues.TransitionType.S_DURATION, Long.valueOf(durationMs))), null, 0L, null, 56, null);
        }

        public final ValidationResult validateAction(Action action) {
            k.f(action, "action");
            try {
                boolean z10 = true;
                switch (WhenMappings.$EnumSwitchMapping$0[action.getType().ordinal()]) {
                    case 1:
                        validateCoordinate(action.getX(), "X coordinate");
                        validateCoordinate(action.getY(), "Y coordinate");
                        break;
                    case 2:
                        String text = action.getText();
                        if (text != null && !m.s0(text)) {
                            z10 = false;
                        }
                        if (!z10) {
                            validateText(text, 10000, "Text");
                            validateCoordinate(action.getX(), "X coordinate");
                            validateCoordinate(action.getY(), "Y coordinate");
                            break;
                        } else {
                            throw new IllegalArgumentException("Text cannot be blank");
                        }
                        break;
                    case 3:
                        validateCoordinate(action.getX(), "Start X coordinate");
                        validateCoordinate(action.getY(), "Start Y coordinate");
                        validateCoordinate(action.getEndX(), "End X coordinate");
                        validateCoordinate(action.getEndY(), "End Y coordinate");
                        if (action.getX() == action.getEndX() && action.getY() == action.getEndY()) {
                            throw new IllegalArgumentException("Swipe start and end points cannot be the same");
                        }
                        break;
                    case 4:
                        validateDuration(action.getDuration());
                        break;
                    case 5:
                        String packageName = action.getPackageName();
                        if (packageName != null && !m.s0(packageName)) {
                            z10 = false;
                        }
                        if (!z10) {
                            validatePackageName(packageName);
                            break;
                        } else {
                            throw new IllegalArgumentException("Package name cannot be blank");
                        }
                        break;
                    case 6:
                        String message = action.getMessage();
                        if (message != null && !m.s0(message)) {
                            z10 = false;
                        }
                        if (!z10) {
                            validateText(message, 1000, "Message");
                            break;
                        } else {
                            throw new IllegalArgumentException("Message cannot be blank");
                        }
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return ValidationResult.Success.INSTANCE;
            } catch (IllegalArgumentException e) {
                String message2 = e.getMessage();
                if (message2 == null) {
                    message2 = "Validation failed";
                }
                return new ValidationResult.Error(message2);
            } catch (Exception e6) {
                return new ValidationResult.Error(B7.a.k("Unexpected validation error: ", e6.getMessage()));
            }
        }

        private Companion() {
        }
    }

    public Action(String id, ActionType type, Map<String, ? extends Object> parameters, ActionState state, long j5, String str) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(parameters, "parameters");
        k.f(state, "state");
        this.id = id;
        this.type = type;
        this.parameters = parameters;
        this.state = state;
        this.timestamp = j5;
        this.errorMessage = str;
    }

    public static /* synthetic */ Action copy$default(Action action, String str, ActionType actionType, Map map, ActionState actionState, long j5, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = action.id;
        }
        if ((i & 2) != 0) {
            actionType = action.type;
        }
        if ((i & 4) != 0) {
            map = action.parameters;
        }
        if ((i & 8) != 0) {
            actionState = action.state;
        }
        if ((i & 16) != 0) {
            j5 = action.timestamp;
        }
        if ((i & 32) != 0) {
            str2 = action.errorMessage;
        }
        String str3 = str2;
        long j6 = j5;
        return action.copy(str, actionType, map, actionState, j6, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final ActionType getType() {
        return this.type;
    }

    public final Map<String, Object> component3() {
        return this.parameters;
    }

    /* renamed from: component4, reason: from getter */
    public final ActionState getState() {
        return this.state;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Action copy(String id, ActionType type, Map<String, ? extends Object> parameters, ActionState state, long timestamp, String errorMessage) {
        k.f(id, "id");
        k.f(type, "type");
        k.f(parameters, "parameters");
        k.f(state, "state");
        return new Action(id, type, parameters, state, timestamp, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Action)) {
            return false;
        }
        Action action = (Action) other;
        return k.b(this.id, action.id) && this.type == action.type && k.b(this.parameters, action.parameters) && this.state == action.state && this.timestamp == action.timestamp && k.b(this.errorMessage, action.errorMessage);
    }

    public final long getDuration() {
        long jLongValue;
        Object obj = this.parameters.get(TypedValues.TransitionType.S_DURATION);
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            jLongValue = l.longValue();
        } else {
            Object obj2 = this.parameters.get(TypedValues.TransitionType.S_DURATION);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Long lG0 = str != null ? t.g0(str) : null;
            jLongValue = lG0 != null ? lG0.longValue() : 0L;
        }
        if (jLongValue < 0) {
            throw new IllegalArgumentException(b.p(jLongValue, "Duration must be non-negative: ").toString());
        }
        if (jLongValue <= 300000) {
            return jLongValue;
        }
        throw new IllegalArgumentException(b.q(jLongValue, "Duration too long: ", " > 300000").toString());
    }

    public final int getEndX() {
        int iIntValue;
        Object obj = this.parameters.get("endX");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Object obj2 = this.parameters.get("endX");
            String str = obj2 instanceof String ? (String) obj2 : null;
            Integer numF0 = str != null ? t.f0(str) : null;
            iIntValue = numF0 != null ? numF0.intValue() : 0;
        }
        if (iIntValue < 0) {
            throw new IllegalArgumentException(B7.a.h(iIntValue, "EndX coordinate must be non-negative: ").toString());
        }
        if (iIntValue <= 10000) {
            return iIntValue;
        }
        throw new IllegalArgumentException(B7.a.h(iIntValue, "EndX coordinate too large: ").toString());
    }

    public final int getEndY() {
        int iIntValue;
        Object obj = this.parameters.get("endY");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Object obj2 = this.parameters.get("endY");
            String str = obj2 instanceof String ? (String) obj2 : null;
            Integer numF0 = str != null ? t.f0(str) : null;
            iIntValue = numF0 != null ? numF0.intValue() : 0;
        }
        if (iIntValue < 0) {
            throw new IllegalArgumentException(B7.a.h(iIntValue, "EndY coordinate must be non-negative: ").toString());
        }
        if (iIntValue <= 10000) {
            return iIntValue;
        }
        throw new IllegalArgumentException(B7.a.h(iIntValue, "EndY coordinate too large: ").toString());
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessage() {
        Object obj = this.parameters.get("message");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() <= 1000) {
            return str;
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(str.length(), "Message too long: ", " > 1000").toString());
    }

    public final String getPackageName() {
        Object obj = this.parameters.get("packageName");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (m.s0(str)) {
                throw new IllegalArgumentException("Package name cannot be blank");
            }
            if (!PACKAGE_NAME_REGEX.d(str)) {
                throw new IllegalArgumentException("Invalid package name format: ".concat(str).toString());
            }
        }
        return str;
    }

    public final Map<String, Object> getParameters() {
        return this.parameters;
    }

    public final ActionState getState() {
        return this.state;
    }

    public final String getText() {
        Object obj = this.parameters.get("text");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() <= 10000) {
            return str;
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(str.length(), "Text too long: ", " > 10000").toString());
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ActionType getType() {
        return this.type;
    }

    public final int getX() {
        int iIntValue;
        Object obj = this.parameters.get("x");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Object obj2 = this.parameters.get("x");
            String str = obj2 instanceof String ? (String) obj2 : null;
            Integer numF0 = str != null ? t.f0(str) : null;
            iIntValue = numF0 != null ? numF0.intValue() : 0;
        }
        if (iIntValue < 0) {
            throw new IllegalArgumentException(B7.a.h(iIntValue, "X coordinate must be non-negative: ").toString());
        }
        if (iIntValue <= 10000) {
            return iIntValue;
        }
        throw new IllegalArgumentException(B7.a.h(iIntValue, "X coordinate too large: ").toString());
    }

    public final int getY() {
        int iIntValue;
        Object obj = this.parameters.get("y");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Object obj2 = this.parameters.get("y");
            String str = obj2 instanceof String ? (String) obj2 : null;
            Integer numF0 = str != null ? t.f0(str) : null;
            iIntValue = numF0 != null ? numF0.intValue() : 0;
        }
        if (iIntValue < 0) {
            throw new IllegalArgumentException(B7.a.h(iIntValue, "Y coordinate must be non-negative: ").toString());
        }
        if (iIntValue <= 10000) {
            return iIntValue;
        }
        throw new IllegalArgumentException(B7.a.h(iIntValue, "Y coordinate too large: ").toString());
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c((this.state.hashCode() + androidx.appfunctions.metadata.a.f(this.parameters, (this.type.hashCode() + (this.id.hashCode() * 31)) * 31, 31)) * 31, 31, this.timestamp);
        String str = this.errorMessage;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Action(id=" + this.id + ", type=" + this.type + ", parameters=" + this.parameters + ", state=" + this.state + ", timestamp=" + this.timestamp + ", errorMessage=" + this.errorMessage + ")";
    }

    public /* synthetic */ Action(String str, ActionType actionType, Map map, ActionState actionState, long j5, String str2, int i, e eVar) {
        this(str, actionType, map, (i & 8) != 0 ? ActionState.PENDING : actionState, (i & 16) != 0 ? System.currentTimeMillis() : j5, (i & 32) != 0 ? null : str2);
    }
}
