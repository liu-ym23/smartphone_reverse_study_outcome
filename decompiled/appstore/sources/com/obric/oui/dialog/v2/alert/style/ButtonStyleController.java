package com.obric.oui.dialog.v2.alert.style;

import android.content.DialogInterface;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ButtonStyleController implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14472a = null;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$ButtonStyle;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/ButtonStyleController$TextColorType;", "", "(Ljava/lang/String;I)V", "TextReverse", "TextReverse2", "Negative", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "待废弃")
    public static final enum TextColorType extends Enum<TextColorType> {
        private static final /* synthetic */ TextColorType[] $VALUES = null;
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        private static final /* synthetic */ TextColorType[] $values() {
            return new TextColorType[]{TextReverse, TextReverse2, Negative};
        }

        static {
            TextReverse = new TextColorType("TextReverse", 0);
            TextReverse2 = new TextColorType("TextReverse2", 1);
            Negative = new TextColorType("Negative", 2);
            $VALUES = $values();
        }

        private TextColorType(String r10, int r11) {
            super(r10, r11);
        }

        public static TextColorType valueOf(String r10) {
            return (TextColorType) Enum.valueOf(TextColorType.class, r10);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f14472a = new a(null);
    }

    public ButtonStyleController() {
    }

    public abstract View a();

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public abstract void attachToHost(AlertDialogHost r10);

    public abstract View b();

    public abstract View c();

    public abstract void d(View r10);

    public abstract void e(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12);

    public abstract void f(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12);

    public abstract void g(CharSequence r10, DialogInterface.OnClickListener r11, TextColorType r12, boolean r13);
}
