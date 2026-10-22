package com.android.server.power;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class AutoBrightnessDebugView extends RelativeLayout {
    private static int TITLE_COLOR;
    private TextView mAvgLuxView;
    private LinearLayout mBrightnessLines;
    private ArrayList<TextView> mBrightnessViews;
    private Context mContext;
    private TextView mCurBrightnessView;
    private TextView mCurLuxView;
    private TextView mCurTimeView;
    private Handler mHandler;
    private LinearLayout mLuxLines;
    private ArrayList<TextView> mLuxViews;
    private LinearLayout mMainView;
    private TextView mRequestedBrightnessView;
    private ContentResolver mResolver;
    private SettingsObserver mSettingsObserver;

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ AutoBrightnessDebugView this$0;

        public SettingsObserver(AutoBrightnessDebugView r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            int brightness = Settings.System.getInt(AutoBrightnessDebugView.m7390$$Nest$fgetmResolver(this.this$0), "realtime_screen_brightness", 0);
            AutoBrightnessDebugView.m7389$$Nest$fgetmCurBrightnessView(this.this$0).setText(Integer.toString(brightness));
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurBrightnessView, reason: not valid java name */
    static /* bridge */ /* synthetic */ TextView m7389$$Nest$fgetmCurBrightnessView(AutoBrightnessDebugView r0) {
        return r0.mCurBrightnessView;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m7390$$Nest$fgetmResolver(AutoBrightnessDebugView r0) {
        return r0.mResolver;
    }

    static {
        TITLE_COLOR = -1728053061;
    }

    public AutoBrightnessDebugView(Context context) {
        super(context);
        this.mLuxViews = new ArrayList();
        this.mBrightnessViews = new ArrayList();
        this.mContext = context;
        this.mHandler = new Handler();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mResolver = this.mContext.getContentResolver();
        setGravity(83);
        this.mMainView = new LinearLayout(this.mContext);
        this.mMainView.setOrientation(1);
        this.mMainView.setBackgroundColor(-1728053095);
        addView(this.mMainView);
        TextView curLuxTitleView = new TextView(context);
        curLuxTitleView.setText("Current lux:");
        curLuxTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(curLuxTitleView);
        this.mCurLuxView = new TextView(context);
        this.mCurLuxView.setTextColor(-1714584320);
        this.mMainView.addView(this.mCurLuxView);
        TextView curTimeTitleView = new TextView(context);
        curTimeTitleView.setText("Current Time:");
        curTimeTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(curTimeTitleView);
        this.mCurTimeView = new TextView(context);
        this.mCurTimeView.setTextColor(-1714584320);
        this.mMainView.addView(this.mCurTimeView);
        TextView avgLuxTitleView = new TextView(context);
        avgLuxTitleView.setText("avg lux:");
        avgLuxTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(avgLuxTitleView);
        this.mAvgLuxView = new TextView(context);
        this.mAvgLuxView.setTextColor(-1714584320);
        this.mMainView.addView(this.mAvgLuxView);
        TextView brightnessTitleView = new TextView(context);
        brightnessTitleView.setText("Current birghtness:");
        brightnessTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(brightnessTitleView);
        this.mCurBrightnessView = new TextView(context);
        this.mCurBrightnessView.setTextColor(-1714584320);
        this.mMainView.addView(this.mCurBrightnessView);
        TextView reqBriTitleView = new TextView(context);
        reqBriTitleView.setText("Requested birghtness:");
        reqBriTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(reqBriTitleView);
        this.mRequestedBrightnessView = new TextView(context);
        this.mRequestedBrightnessView.setTextColor(-1714584320);
        this.mMainView.addView(this.mRequestedBrightnessView);
        TextView mapTitleView = new TextView(context);
        mapTitleView.setText("Map:");
        mapTitleView.setBackgroundColor(TITLE_COLOR);
        this.mMainView.addView(mapTitleView);
        this.mLuxLines = new LinearLayout(context);
        this.mLuxLines.setOrientation(1);
        this.mLuxLines.addView(new TextView(this.mContext));
        this.mBrightnessLines = new LinearLayout(context);
        this.mBrightnessLines.setOrientation(1);
        LinearLayout line = new LinearLayout(context);
        line.setOrientation(0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        line.addView(this.mLuxLines, params);
        line.addView(this.mBrightnessLines, params);
        this.mMainView.addView(line);
    }

    public void updateCurLuxData(String lux) {
        this.mCurLuxView.setText(lux);
    }

    public void updateCurTimeData(String lux) {
        this.mCurTimeView.setText(lux);
    }

    public void updateAvgLuxData(float lux) {
        this.mAvgLuxView.setText(Float.toString(lux));
    }

    public void updateReqestedBrightnessData(float brightness) {
        this.mRequestedBrightnessView.setText(Float.toString(brightness));
    }

    public void updateLuxBrightnessData(int[] luxes, float[] brightnesses) {
        if (this.mLuxViews.size() >= luxes.length) goto L10;
        int i = this.mLuxViews.size();
    L6:
        if (i >= luxes.length) goto L16;
        TextView luxTextView = new TextView(this.mContext);
        this.mLuxViews.add(luxTextView);
        this.mLuxLines.addView(luxTextView);
        i = i + 1;
    L16:
        if (this.mBrightnessViews.size() >= brightnesses.length) goto L23;
        int i2 = this.mBrightnessViews.size();
    L19:
        if (i2 >= brightnesses.length) goto L28;
        TextView briTextView = new TextView(this.mContext);
        this.mBrightnessViews.add(briTextView);
        this.mBrightnessLines.addView(briTextView);
        i2 = i2 + 1;
    L28:
        int i3 = 0;
        Iterator<TextView> r1 = this.mLuxViews.iterator();
    L30:
        if (r1.hasNext() == false) goto L32;
        TextView tv = r1.next();
        tv.setText(Integer.toString(luxes[i3]));
        i3 = i3 + 1;
        goto L30
    L32:
        int i4 = 0;
        Iterator<TextView> r2 = this.mBrightnessViews.iterator();
    L34:
        if (r2.hasNext() == false) goto L36;
        TextView tv2 = r2.next();
        tv2.setText(Float.toString(brightnesses[i4]));
        i4 = i4 + 1;
        goto L34
    L36:
        return;
    L23:
        if (this.mBrightnessViews.size() <= brightnesses.length) goto L28;
        int i5 = brightnesses.length - 1;
    L26:
        if (i5 >= this.mBrightnessViews.size()) goto L28;
        this.mBrightnessLines.removeView(this.mBrightnessViews.remove(i5));
        i5 = i5 + 1;
        goto L26
    L10:
        if (this.mLuxViews.size() <= luxes.length) goto L16;
        int i6 = luxes.length - 1;
    L13:
        if (i6 >= this.mLuxViews.size()) goto L16;
        this.mLuxLines.removeView(this.mLuxViews.remove(i6));
        i6 = i6 + 1;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mResolver.registerContentObserver(Settings.System.getUriFor("realtime_screen_brightness"), false, this.mSettingsObserver, -1);
        this.mSettingsObserver.onChange(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mResolver.unregisterContentObserver(this.mSettingsObserver);
    }
}
