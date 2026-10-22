package com.stepos.policy.sdk.util;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyLinkMovementMethod extends LinkMovementMethod {
    public static final Companion Companion = new Companion(null);
    private static final PolicyLinkMovementMethod INSTANCE = new PolicyLinkMovementMethod();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMovementKey(int i10) {
            if (i10 == 92 || i10 == 93 || i10 == 122 || i10 == 123) {
                return true;
            }
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                    return true;
                default:
                    return false;
            }
        }

        public final PolicyLinkMovementMethod getInstance() {
            return PolicyLinkMovementMethod.INSTANCE;
        }

        private Companion() {
        }
    }

    private PolicyLinkMovementMethod() {
    }

    public static final PolicyLinkMovementMethod getInstance() {
        return Companion.getInstance();
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean bottom(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean down(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean end(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean home(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean left(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean lineEnd(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean lineStart(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyDown(TextView widget, Spannable text, int i10, KeyEvent event) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(event, "event");
        if (Companion.isMovementKey(i10)) {
            return false;
        }
        return super.onKeyDown(widget, text, i10, event);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyOther(TextView view, Spannable text, KeyEvent event) {
        kotlin.jvm.internal.g.f(view, "view");
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(event, "event");
        if (Companion.isMovementKey(event.getKeyCode())) {
            return false;
        }
        return super.onKeyOther(view, text, event);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyUp(TextView widget, Spannable text, int i10, KeyEvent event) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(event, "event");
        if (Companion.isMovementKey(i10)) {
            return false;
        }
        return super.onKeyUp(widget, text, i10, event);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean pageDown(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean pageUp(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean right(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean top(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean up(TextView widget, Spannable buffer) {
        kotlin.jvm.internal.g.f(widget, "widget");
        kotlin.jvm.internal.g.f(buffer, "buffer");
        return false;
    }
}
