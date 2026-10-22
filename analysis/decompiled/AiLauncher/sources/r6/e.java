package r6;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.stepos.ailauncher.chat.widget.FigmaSwitch;
import com.stepos.ailauncher.task.R$id;
import s1.C5437a;

/* loaded from: classes3.dex */
public final class e {
    public final ImageView btnClose;
    public final LinearLayout itemAboutMe;
    public final LinearLayout itemCommunication;
    public final LinearLayout itemMemo;
    public final LinearLayout itemMemoryShare;
    private final LinearLayout rootView;
    public final FigmaSwitch switchMemoryShare;

    public e(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, FigmaSwitch figmaSwitch) {
        this.rootView = linearLayout;
        this.btnClose = imageView;
        this.itemAboutMe = linearLayout2;
        this.itemCommunication = linearLayout3;
        this.itemMemo = linearLayout4;
        this.itemMemoryShare = linearLayout5;
        this.switchMemoryShare = figmaSwitch;
    }

    public static e a(View view) {
        int i10 = R$id.btn_close;
        ImageView imageView = (ImageView) C5437a.a(view, i10);
        if (imageView != null) {
            i10 = R$id.item_about_me;
            LinearLayout linearLayout = (LinearLayout) C5437a.a(view, i10);
            if (linearLayout != null) {
                i10 = R$id.item_communication;
                LinearLayout linearLayout2 = (LinearLayout) C5437a.a(view, i10);
                if (linearLayout2 != null) {
                    i10 = R$id.item_memo;
                    LinearLayout linearLayout3 = (LinearLayout) C5437a.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R$id.item_memory_share;
                        LinearLayout linearLayout4 = (LinearLayout) C5437a.a(view, i10);
                        if (linearLayout4 != null) {
                            i10 = R$id.switch_memory_share;
                            FigmaSwitch figmaSwitch = (FigmaSwitch) C5437a.a(view, i10);
                            if (figmaSwitch != null) {
                                return new e((LinearLayout) view, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, figmaSwitch);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }
}
