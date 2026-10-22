package com.stepos.policy.sdk.util;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.stepos.mcp.sdk.base.AppUI;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyLinkMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "()V", "bottom", "", AppUI.TYPE_WIDGET, "Landroid/widget/TextView;", "buffer", "Landroid/text/Spannable;", "down", "end", "home", "left", "lineEnd", "lineStart", "onKeyDown", "text", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onKeyOther", "view", "onKeyUp", "pageDown", "pageUp", "right", "top", "up", "Companion", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyLinkMovementMethod extends LinkMovementMethod {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PolicyLinkMovementMethod INSTANCE = new PolicyLinkMovementMethod();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyLinkMovementMethod$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/policy/sdk/util/PolicyLinkMovementMethod;", "getInstance", "isMovementKey", "", "keyCode", "", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMovementKey(int keyCode) {
            if (keyCode == 92 || keyCode == 93 || keyCode == 122 || keyCode == 123) {
                return true;
            }
            switch (keyCode) {
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
        return INSTANCE.getInstance();
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean bottom(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean down(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean end(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean home(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean left(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean lineEnd(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean lineStart(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        k.f(widget, "widget");
        k.f(text, "text");
        k.f(event, "event");
        if (INSTANCE.isMovementKey(keyCode)) {
            return false;
        }
        return super.onKeyDown(widget, text, keyCode, event);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyOther(TextView view, Spannable text, KeyEvent event) {
        k.f(view, "view");
        k.f(text, "text");
        k.f(event, "event");
        if (INSTANCE.isMovementKey(event.getKeyCode())) {
            return false;
        }
        return super.onKeyOther(view, text, event);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event) {
        k.f(widget, "widget");
        k.f(text, "text");
        k.f(event, "event");
        if (INSTANCE.isMovementKey(keyCode)) {
            return false;
        }
        return super.onKeyUp(widget, text, keyCode, event);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean pageDown(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean pageUp(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean right(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean top(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean up(TextView widget, Spannable buffer) {
        k.f(widget, "widget");
        k.f(buffer, "buffer");
        return false;
    }
}
