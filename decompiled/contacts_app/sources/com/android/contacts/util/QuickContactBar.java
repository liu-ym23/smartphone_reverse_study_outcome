package com.android.contacts.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.ContactsUtils;
import com.android.vcard.VCardConstants;

/* JADX INFO: loaded from: classes2.dex */
public class QuickContactBar extends View {
    private String[] letters;
    private Paint paint;
    private QuickContactBarNaviListener quickContactBarNaviListener;

    public interface QuickContactBarNaviListener {
        void naviToLetter(String r1);
    }

    static /* synthetic */ String[] access$000(QuickContactBar r0) {
        return r0.letters;
    }

    static /* synthetic */ QuickContactBarNaviListener access$100(QuickContactBar r0) {
        return r0.quickContactBarNaviListener;
    }

    public QuickContactBar(Context r30) {
        super(r30);
        this.paint = new Paint();
        this.letters = new String[]{ContactsUtils.CHAR_POUND, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, VCardConstants.PARAM_ENCODING_B, "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.quickContactBarNaviListener = null;
        init();
    }

    public QuickContactBar(Context r30, AttributeSet r31) {
        super(r30, r31);
        this.paint = new Paint();
        this.letters = new String[]{ContactsUtils.CHAR_POUND, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, VCardConstants.PARAM_ENCODING_B, "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.quickContactBarNaviListener = null;
        init();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        float r5 = r4.getY() / getHeight();
        String[] r0 = this.letters;
        final int r6 = (int) (r5 * r0.length);
        if (r6 < r0.length) goto L6;
        r6 = r0.length - 1;
    L6:
        if (this.quickContactBarNaviListener == null) goto L8;
        new Handler().post(new AnonymousClass1(this, r6));
    L8:
        return true;
    }

    public void setQuickNaviListener(QuickContactBarNaviListener r1) {
        this.quickContactBarNaviListener = r1;
    }

    private void init() {
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setFakeBoldText(true);
        this.paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r8) {
        int r0 = 0;
        r8.drawColor(0);
        super.onDraw(r8);
        int r1 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r3 = getPaddingTop() + getTop();
        int r4 = r2 / this.letters.length;
        if (r4 >= r1) goto L5;
        int r5 = r4 - 3;
    L6:
        this.paint.setTextSize(r5);
    L8:
        if (r0 >= this.letters.length) goto L10;
        float r6 = (getWidth() - this.paint.measureText(this.letters[r0])) / 2.0f;
        r8.drawText(this.letters[r0], r6, (r4 * r0) + r3, this.paint);
        r0 = r0 + 1;
        goto L8
    L10:
        return;
    L5:
        r5 = r1 - 2;
        goto L6
    }
}
