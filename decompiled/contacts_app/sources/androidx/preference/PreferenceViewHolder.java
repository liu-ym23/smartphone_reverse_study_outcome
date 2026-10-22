package androidx.preference;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    private final Drawable mBackground;
    private final SparseArray<View> mCachedViews;
    private boolean mDividerAllowedAbove;
    private boolean mDividerAllowedBelow;
    private ColorStateList mTitleTextColors;

    PreferenceViewHolder(View r5) {
        super(r5);
        SparseArray<View> r0 = new SparseArray(4);
        this.mCachedViews = r0;
        TextView r2 = (TextView) r5.findViewById(android.R.id.title);
        r0.put(android.R.id.title, r2);
        r0.put(android.R.id.summary, r5.findViewById(android.R.id.summary));
        r0.put(android.R.id.icon, r5.findViewById(android.R.id.icon));
        r0.put(R.id.icon_frame, r5.findViewById(R.id.icon_frame));
        r0.put(16908350, r5.findViewById(16908350));
        this.mBackground = r5.getBackground();
        if (r2 == null) goto L6;
        this.mTitleTextColors = r2.getTextColors();
        return;
    }

    public static PreferenceViewHolder createInstanceForTests(View r1) {
        return new PreferenceViewHolder(r1);
    }

    public View findViewById(int r2) {
        View r0 = this.mCachedViews.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        View r1 = this.itemView.findViewById(r2);
        if (r1 == null) goto L8;
        this.mCachedViews.put(r2, r1);
    L8:
        return r1;
    }

    public boolean isDividerAllowedAbove() {
        return this.mDividerAllowedAbove;
    }

    public void setDividerAllowedAbove(boolean r1) {
        this.mDividerAllowedAbove = r1;
    }

    public boolean isDividerAllowedBelow() {
        return this.mDividerAllowedBelow;
    }

    public void setDividerAllowedBelow(boolean r1) {
        this.mDividerAllowedBelow = r1;
    }

    void resetState() {
        if (this.itemView.getBackground() == this.mBackground) goto L5;
        ViewCompat.setBackground(this.itemView, this.mBackground);
    L5:
        TextView r0 = (TextView) findViewById(android.R.id.title);
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.mTitleTextColors != null) goto L10;
        return;
    L10:
        if (r0.getTextColors().equals(this.mTitleTextColors) == true) goto L15;
        r0.setTextColor(this.mTitleTextColors);
        return;
    }
}
