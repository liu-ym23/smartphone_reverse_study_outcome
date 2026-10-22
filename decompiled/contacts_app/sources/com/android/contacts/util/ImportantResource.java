package com.android.contacts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.contacts.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ImportantResource {
    private static ImportantResource mImportantResource;
    private Context mContext;
    private boolean mIsTooLate;
    private int[] mNecessary;
    private HashMap<Integer, Drawable> mResourceMap;
    private Resources mResources;

    static {
    }

    static /* synthetic */ void access$000(ImportantResource r0) {
        r0.preLoadResource();
    }

    private ImportantResource(Context r2) {
        this.mContext = null;
        this.mResources = null;
        this.mIsTooLate = false;
        this.mResourceMap = new HashMap();
        this.mNecessary = new int[]{R.drawable.o_dial_btn_1, R.drawable.o_dial_btn_2, R.drawable.o_dial_btn_3, R.drawable.o_dial_btn_4, R.drawable.o_dial_btn_5, R.drawable.o_dial_btn_6, R.drawable.o_dial_btn_7, R.drawable.o_dial_btn_8, R.drawable.o_dial_btn_9, R.drawable.o_dial_btn_0, R.drawable.o_dial_btn_call, R.drawable.o_dial_btn_delete_left, R.drawable.o_dial_btn_asterisk, R.drawable.o_dial_btn_poundsign, R.drawable.o_dial_btn_yellow, R.drawable.o_dial_btn_delete_right, R.drawable.o_dial_btn_move_left, R.drawable.o_dial_btn_move_right, R.drawable.o_dial_btn_add, R.drawable.o_dial_table_bg_left, R.drawable.o_dial_table_bg_right, R.drawable.o_dial_table_bg, R.drawable.ic_o, R.drawable.o_ic_close};
        this.mContext = r2;
        this.mResources = r2.getResources();
    }

    public void needPreLoadResource() {
        new Thread(new AnonymousClass1(this), "initPreLoadResource").start();
    }

    private void preLoadResource() {
        if (this.mIsTooLate == false) goto L5;
        return;
    L5:
        int[] r0 = this.mNecessary;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int r3 = r0[r2];
        this.mResourceMap.put(Integer.valueOf(r3), this.mResources.getDrawable(r3));
        r2 = r2 + 1;
        goto L6
    L8:
        new ConstraintLayout(this.mContext);
    }

    public static synchronized ImportantResource getInstance(Context r2) {
        monitor-enter(ImportantResource.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mImportantResource != null) goto L7;
        mImportantResource = new ImportantResource(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        ImportantResource r3 = mImportantResource;     // Catch: Throwable -> L10
        monitor-exit(ImportantResource.class);
        return r3;
    }

    public Drawable getResource(int r3) {
        Drawable r0 = this.mResourceMap.get(Integer.valueOf(r3));
        if (r0 != null) goto L6;
        this.mIsTooLate = true;
        Drawable r1 = this.mResources.getDrawable(r3);
        this.mResourceMap.put(Integer.valueOf(r3), r1);
        return r1;
    L6:
        return r0;
    }

    public void clear() {
        this.mIsTooLate = false;
        this.mResourceMap.clear();
    }

    public int getDrawableCount() {
        return this.mResourceMap.keySet().size();
    }
}
