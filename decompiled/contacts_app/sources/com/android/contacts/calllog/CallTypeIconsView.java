package com.android.contacts.calllog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.contacts.R;
import com.google.common.collect.Lists;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CallTypeIconsView extends ImageView {
    private List<Integer> mCallTypes;
    private int mHeight;
    private boolean mIsStateful;
    private Resources mResources;
    private int mWidth;

    private static class Resources {
        public final int iconMargin;
        public final Drawable incoming;
        public final Drawable missed;
        public final Drawable outgoing;
        public final Drawable voicemail;

        public Resources(Context r3) {
            android.content.res.Resources r4 = r3.getResources();
            this.incoming = r4.getDrawable(R.drawable.ic_call_incoming_holo_dark);
            this.outgoing = r4.getDrawable(R.drawable.ic_call_outgoing_holo_dark);
            this.missed = r4.getDrawable(R.drawable.ic_call_incoming_holo_dark);
            this.voicemail = r4.getDrawable(R.drawable.ic_call_voicemail_holo_dark);
            this.iconMargin = r4.getDimensionPixelSize(R.dimen.call_log_icon_margin);
        }
    }

    public CallTypeIconsView(Context r2) {
        this(r2, null);
    }

    public CallTypeIconsView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mCallTypes = Lists.newArrayListWithCapacity(3);
        this.mIsStateful = true;
        this.mResources = new Resources(r1);
    }

    public void clear() {
        this.mCallTypes.clear();
        this.mWidth = 0;
        this.mHeight = 0;
        invalidate();
    }

    public void add(int r4) {
        this.mCallTypes.add(Integer.valueOf(r4));
        Drawable r0 = getCallTypeDrawable(r4);
        if (r0 == null) goto L9;
        this.mWidth += r0.getIntrinsicWidth();
        this.mHeight = Math.max(this.mHeight, r0.getIntrinsicHeight());
        if (r4 != 4) goto L7;
        this.mWidth += this.mResources.iconMargin;
    L7:
        setImageDrawable(r0);
        invalidate();
        return;
    }

    public int getCount() {
        return this.mCallTypes.size();
    }

    public int getCallType(int r1) {
        return this.mCallTypes.get(r1).intValue();
    }

    public void setStateful(boolean r1) {
        this.mIsStateful = r1;
    }

    private Drawable getCallTypeDrawable(int r2) {
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L21;
        if (r2 == 4) goto L17;
        if (r2 == 6) goto L21;
        if (r2 == 7) goto L21;
        return null;
    L17:
        return this.mResources.voicemail;
    L19:
        return getCallTypeDrawable(this.mResources.outgoing);
    L21:
        return getCallTypeDrawable(this.mResources.incoming);
    }

    private Drawable getCallTypeDrawable(Drawable r1) {
        if (this.mIsStateful == false) goto L6;
        return r1;
    L6:
        if ((r1 instanceof StateListDrawable) == false) goto L9;
        StateListDrawable r2 = (StateListDrawable) r1;
        return r2.getStateDrawable(r2.getStateCount() - 1);
    L9:
        return r1;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r1, int r2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }
}
