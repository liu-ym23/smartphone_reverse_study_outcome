package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes17.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor r100);
    }

    public interface ViewBinder {
        boolean setViewValue(View r100, Cursor r101, int r102);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r100) {
        CursorToStringConverter r101 = this.mCursorToStringConverter;
        if (r101 != null) goto L5;
        int r102 = this.mStringConversionColumn;
        if (r102 <= (-1)) goto L11;
        return r100.getString(r102);
    L11:
        return super.convertToString(r100);
    L5:
        return r101.convertToString(r100);
    }

    public void setCursorToStringConverter(CursorToStringConverter r100) {
        this.mCursorToStringConverter = r100;
    }

    public void setStringConversionColumn(int r100) {
        this.mStringConversionColumn = r100;
    }

    public void setViewBinder(ViewBinder r100) {
        this.mViewBinder = r100;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r100) {
        findColumns(r100, this.mOriginalFrom);
        return super.swapCursor(r100);
    }

    private void findColumns(Cursor r100, String[] r101) {
        if (r100 == null) goto L11;
        int r102 = r101.length;
        int[] r103 = this.mFrom;
        if (r103 != null) goto L6;
    L7:
        this.mFrom = new int[r102];
    L8:
        int r104 = 0;
    L9:
        if (r104 >= r102) goto L14;
        this.mFrom[r104] = r100.getColumnIndexOrThrow(r101[r104]);
        r104 = r104 + 1;
        goto L9
    L14:
        return;
    L6:
        if (r103.length == r102) goto L8;
    L11:
        this.mFrom = null;
    }

    public void setViewImage(ImageView r100, String r101) {
        r100.setImageResource(CastIntegerProtector.parseInt(r101));     // Catch: NumberFormatException -> L4
        return;
    L4:
        r100.setImageURI(UriProtector.parse(r101));
    }

    public void setViewText(TextView r100, String r101) {
        r100.setText(r101);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r100, Context r110, Cursor r111) {
        ViewBinder r112 = this.mViewBinder;
        int[] r101 = this.mTo;
        int r102 = r101.length;
        int[] r103 = this.mFrom;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L22;
        View r105 = r100.findViewById(r101[r104]);
        if (r105 == null) goto L21;
        if (r112 == null) goto L8;
        boolean r106 = r112.setViewValue(r105, r111, r103[r104]);
    L9:
        if (r106 == true) goto L21;
        String r107 = r111.getString(r103[r104]);
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        if ((r105 instanceof TextView) == false) goto L17;
        setViewText((TextView) r105, r107);
        goto L21
    L17:
        if ((r105 instanceof ImageView) == false) goto L20;
        setViewImage((ImageView) r105, r107);
        goto L21
    L20:
        throw new IllegalStateException(r105.getClass().getName().concat(" is not a  view that can be bounds by this SimpleCursorAdapter"));
    L8:
        r106 = false;
    L21:
        r104 = r104 + 1;
        goto L3
    }

    public void changeCursorAndColumns(Cursor r100, String[] r101, int[] r102) {
        this.mOriginalFrom = r101;
        this.mTo = r102;
        findColumns(r100, r101);
        super.changeCursor(r100);
    }

    public SimpleCursorAdapter(Context r100, int r101, Cursor r102, String[] r103, int[] r104) {
        super(r100, r101, r102);
        this.mStringConversionColumn = -1;
        this.mTo = r104;
        this.mOriginalFrom = r103;
        findColumns(r102, r103);
    }

    public SimpleCursorAdapter(Context r100, int r101, Cursor r102, String[] r103, int[] r104, int r105) {
        super(r100, r101, r102, r105);
        this.mStringConversionColumn = -1;
        this.mTo = r104;
        this.mOriginalFrom = r103;
        findColumns(r102, r103);
    }
}
