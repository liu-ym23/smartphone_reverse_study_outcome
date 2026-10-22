package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes2.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater r100 = this.mDropDownInflater;
            if (r100 == null) goto L6;
            return r100;
        L6:
            return this.mInflater;
        }

        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater r100 = this.mDropDownInflater;
            if (r100 != null) goto L6;
            return null;
        L6:
            return r100.getContext().getTheme();
        }

        public Helper(Context r100) {
            this.mContext = r100;
            this.mInflater = LayoutInflater.from(r100);
        }

        public void setDropDownViewTheme(Resources.Theme r100) {
            if (r100 != null) goto L5;
            this.mDropDownInflater = null;
            return;
        L5:
            if (r100 != this.mContext.getTheme()) goto L7;
            this.mDropDownInflater = this.mInflater;
            return;
        L7:
            this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, r100));
        }
    }

    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources.Theme r100);
}
