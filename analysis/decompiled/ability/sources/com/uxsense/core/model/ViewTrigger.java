package com.uxsense.core.model;

import B9.T;
import C7.f;
import K7.a;
import P3.d;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Locale;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0087\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/uxsense/core/model/ViewTrigger;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "ON_CLICK", "ON_LONG_CLICK", "ON_FOCUS", "ON_BLUR", "ON_VISIBLE", "ON_INVISIBLE", "ON_SCROLL", "ON_TEXT_CHANGED", "ON_SELECTED", "ON_DESELECTED", "ON_CHECKED", "ON_UNCHECKED", "ON_STATE_CHANGED", "ON_SIZE_CHANGED", "ANY", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewTrigger {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ViewTrigger[] $VALUES;
    private static final f $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ViewTrigger ON_CLICK = new ViewTrigger("ON_CLICK", 0);
    public static final ViewTrigger ON_LONG_CLICK = new ViewTrigger("ON_LONG_CLICK", 1);
    public static final ViewTrigger ON_FOCUS = new ViewTrigger("ON_FOCUS", 2);
    public static final ViewTrigger ON_BLUR = new ViewTrigger("ON_BLUR", 3);
    public static final ViewTrigger ON_VISIBLE = new ViewTrigger("ON_VISIBLE", 4);
    public static final ViewTrigger ON_INVISIBLE = new ViewTrigger("ON_INVISIBLE", 5);
    public static final ViewTrigger ON_SCROLL = new ViewTrigger("ON_SCROLL", 6);
    public static final ViewTrigger ON_TEXT_CHANGED = new ViewTrigger("ON_TEXT_CHANGED", 7);
    public static final ViewTrigger ON_SELECTED = new ViewTrigger("ON_SELECTED", 8);
    public static final ViewTrigger ON_DESELECTED = new ViewTrigger("ON_DESELECTED", 9);
    public static final ViewTrigger ON_CHECKED = new ViewTrigger("ON_CHECKED", 10);
    public static final ViewTrigger ON_UNCHECKED = new ViewTrigger("ON_UNCHECKED", 11);
    public static final ViewTrigger ON_STATE_CHANGED = new ViewTrigger("ON_STATE_CHANGED", 12);
    public static final ViewTrigger ON_SIZE_CHANGED = new ViewTrigger("ON_SIZE_CHANGED", 13);
    public static final ViewTrigger ANY = new ViewTrigger("ANY", 14);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/uxsense/core/model/ViewTrigger$Companion;", "", AppAgent.CONSTRUCT, "()V", "", HintConstants.AUTOFILL_HINT_NAME, "", "fromName", "(Ljava/lang/String;)I", "Lcom/uxsense/core/model/ViewTrigger;", "fromNameOrDefault", "(Ljava/lang/String;)Lcom/uxsense/core/model/ViewTrigger;", "Lx9/b;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) ViewTrigger.$cachedSerializer$delegate.getF4884a();
        }

        public final int fromName(String name) {
            if (name == null) {
                return ViewTrigger.ANY.ordinal();
            }
            try {
                String upperCase = name.toUpperCase(Locale.ROOT);
                k.e(upperCase, "toUpperCase(...)");
                return ViewTrigger.valueOf(upperCase).ordinal();
            } catch (IllegalArgumentException unused) {
                return ViewTrigger.ANY.ordinal();
            }
        }

        public final ViewTrigger fromNameOrDefault(String name) {
            if (name == null) {
                return ViewTrigger.ANY;
            }
            try {
                String upperCase = name.toUpperCase(Locale.ROOT);
                k.e(upperCase, "toUpperCase(...)");
                return ViewTrigger.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return ViewTrigger.ANY;
            }
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ViewTrigger[] $values() {
        return new ViewTrigger[]{ON_CLICK, ON_LONG_CLICK, ON_FOCUS, ON_BLUR, ON_VISIBLE, ON_INVISIBLE, ON_SCROLL, ON_TEXT_CHANGED, ON_SELECTED, ON_DESELECTED, ON_CHECKED, ON_UNCHECKED, ON_STATE_CHANGED, ON_SIZE_CHANGED, ANY};
    }

    static {
        ViewTrigger[] viewTriggerArr$values = $values();
        $VALUES = viewTriggerArr$values;
        $ENTRIES = kotlin.enums.a.a(viewTriggerArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = kotlin.a.b(LazyThreadSafetyMode.b, new d(1));
    }

    private ViewTrigger(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _init_$_anonymous_() {
        return T.d("com.uxsense.core.model.ViewTrigger", values());
    }

    public static final int fromName(String str) {
        return INSTANCE.fromName(str);
    }

    public static final ViewTrigger fromNameOrDefault(String str) {
        return INSTANCE.fromNameOrDefault(str);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ViewTrigger valueOf(String str) {
        return (ViewTrigger) Enum.valueOf(ViewTrigger.class, str);
    }

    public static ViewTrigger[] values() {
        return (ViewTrigger[]) $VALUES.clone();
    }
}
