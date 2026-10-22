package stepos.uicontroller;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class UINodeInfo implements Parcelable {
    public static final Parcelable.Creator<UINodeInfo> CREATOR = new Parcelable.Creator<UINodeInfo>() { // from class: stepos.uicontroller.UINodeInfo.1
        @Override // android.os.Parcelable.Creator
        public UINodeInfo createFromParcel(Parcel in) {
            return new UINodeInfo(in);
        }

        @Override // android.os.Parcelable.Creator
        public UINodeInfo[] newArray(int size) {
            return new UINodeInfo[size];
        }
    };
    public static final int INVAILD_ID = -1;
    private Bitmap mBitmap;
    private final Rect mBoundsInScreen;
    private CharSequence mClassName;
    private CharSequence mContentDescription;
    private int mDisplayId;
    private int mNodeId;
    private CharSequence mPackageName;
    private CharSequence mText;

    public UINodeInfo() {
        this.mNodeId = -1;
        this.mBoundsInScreen = new Rect();
    }

    public UINodeInfo(View view) {
        Bitmap bitmap;
        this.mNodeId = -1;
        this.mBoundsInScreen = new Rect();
        setNodeId(view.getAccessibilityViewId());
        view.getBoundsOnScreen(this.mBoundsInScreen, true);
        setContentDescription(view.getContentDescription());
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            setText(TextUtils.isEmpty(text) ? textView.getHint() : text);
        }
        setDisplayId(view.getDisplay().getDisplayId());
        setClassName(view.getClass().getName());
        setPackageName(view.getContext().getPackageName());
        if (!(view instanceof TextView) && (bitmap = getBitmapFromView(view)) != null) {
            setBitmap(bitmap);
        }
    }

    protected UINodeInfo(Parcel in) {
        this.mNodeId = -1;
        this.mBoundsInScreen = new Rect();
        this.mNodeId = in.readInt();
        Rect boundsInScreen = (Rect) in.readParcelable(Rect.class.getClassLoader());
        if (boundsInScreen != null) {
            this.mBoundsInScreen.set(boundsInScreen);
        }
        this.mText = in.readCharSequence();
        this.mContentDescription = in.readCharSequence();
        this.mDisplayId = in.readInt();
        this.mClassName = in.readCharSequence();
        this.mPackageName = in.readCharSequence();
        this.mBitmap = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
    }

    public void setNodeId(int nodeId) {
        this.mNodeId = nodeId;
    }

    public int getNodeId() {
        return this.mNodeId;
    }

    public void setText(CharSequence cs) {
        this.mText = cs;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void setContentDescription(CharSequence cs) {
        this.mContentDescription = cs;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getDisplayId() {
        return this.mDisplayId;
    }

    public void setDisplayId(int displayId) {
        this.mDisplayId = displayId;
    }

    public CharSequence getClassName() {
        return this.mClassName;
    }

    public void setClassName(CharSequence className) {
        this.mClassName = className;
    }

    public CharSequence getPackageName() {
        return this.mPackageName;
    }

    public void setPackageName(CharSequence packageName) {
        this.mPackageName = packageName;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public void setBoundsInScreen(Rect bounds) {
        this.mBoundsInScreen.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void getBoundsInScreen(Rect outBounds) {
        outBounds.set(this.mBoundsInScreen.left, this.mBoundsInScreen.top, this.mBoundsInScreen.right, this.mBoundsInScreen.bottom);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mNodeId);
        dest.writeParcelable(this.mBoundsInScreen, flags);
        dest.writeCharSequence(this.mText);
        dest.writeCharSequence(this.mContentDescription);
        dest.writeInt(this.mDisplayId);
        dest.writeCharSequence(this.mClassName);
        dest.writeCharSequence(this.mPackageName);
        dest.writeParcelable(this.mBitmap, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UINodeInfo{mNodeId=" + this.mNodeId + ", mBoundsInScreen=" + this.mBoundsInScreen + ", mText=" + ((Object) this.mText) + ", mContentDescription=" + ((Object) this.mContentDescription) + ", mDisplayId=" + this.mDisplayId + ", mClassName=" + ((Object) this.mClassName) + ", mPackageName=" + ((Object) this.mPackageName) + '}';
    }

    private Bitmap getBitmapFromView(View view) {
        Bitmap bitmap;
        if (view == null) {
            return null;
        }
        try {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = view.getDrawingCache();
        } catch (Exception e) {
            Slog.e("UINodeInfo", "Error getting bitmap from view");
            view.setDrawingCacheEnabled(false);
        }
        if (bitmap != null) {
            Bitmap result = bitmap.copy(bitmap.getConfig(), true);
            view.setDrawingCacheEnabled(false);
            return result;
        }
        view.setDrawingCacheEnabled(false);
        return null;
    }
}
