package com.stepos.policy.sdk.util;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.widget.TextView;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import j4.k;

/* loaded from: classes.dex */
public final class PolicyLinkMovementMethod extends LinkMovementMethod {
    public static final Companion Companion = new Companion(null);
    private static final PolicyLinkMovementMethod INSTANCE = new PolicyLinkMovementMethod();

    public static final class Companion {
        public /* synthetic */ Companion(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isMovementKey(int i5) {
            if (i5 == 92 || i5 == 93 || i5 == 122 || i5 == 123) {
                return true;
            }
            switch (i5) {
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
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
    protected boolean bottom(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean down(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean end(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean home(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean left(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean lineEnd(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean lineStart(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i5, KeyEvent keyEvent) {
        k.g(textView, "widget");
        k.g(spannable, "text");
        k.g(keyEvent, "event");
        if (Companion.isMovementKey(i5)) {
            return false;
        }
        return super.onKeyDown(textView, spannable, i5, keyEvent);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        k.g(textView, "view");
        k.g(spannable, "text");
        k.g(keyEvent, "event");
        if (Companion.isMovementKey(keyEvent.getKeyCode())) {
            return false;
        }
        return super.onKeyOther(textView, spannable, keyEvent);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyUp(TextView textView, Spannable spannable, int i5, KeyEvent keyEvent) {
        k.g(textView, "widget");
        k.g(spannable, "text");
        k.g(keyEvent, "event");
        if (Companion.isMovementKey(i5)) {
            return false;
        }
        return super.onKeyUp(textView, spannable, i5, keyEvent);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean pageDown(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean pageUp(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean right(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean top(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean up(TextView textView, Spannable spannable) {
        k.g(textView, "widget");
        k.g(spannable, "buffer");
        return false;
    }
}
