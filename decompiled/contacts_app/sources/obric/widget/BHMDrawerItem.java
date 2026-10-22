package obric.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes5.dex */
public class BHMDrawerItem implements Parcelable {
    public static final Parcelable.Creator<BHMDrawerItem> CREATOR = null;
    private static final int DEFAULT_VIEW_TYPE_COUNT = 2;
    public static final int LAST_VIEW_TYPE = 1;
    private static final String TAG = "BHMDrawerItem";
    public static final int VIEW_HEADER = 1;
    public static final int VIEW_ITEM = 0;
    private boolean isEnabled;
    private boolean isShowAlert;
    private boolean isShowProgressBar;
    private String mCount;
    private int mCountColor;
    private int mIconResId;
    private int mPaddingLeft;
    private String mSubTitle;
    private String mTitle;
    private int mViewType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public BHMDrawerItem() {
        this.mViewType = 0;
    }

    public BHMDrawerItem(int viewType) {
        this(viewType, "");
    }

    public BHMDrawerItem(int viewType, String title) {
        this.mViewType = viewType;
        setEnabled(calculateEnabled());
        this.mTitle = title;
    }

    public BHMDrawerItem(int viewType, String title, int iconResId, String count, int countColor, boolean showProgressBar, boolean showAlert, String subTitle, int paddingLeft) {
        this(viewType, title);
        this.mIconResId = iconResId;
        this.mCount = count;
        this.mCountColor = countColor;
        this.isShowProgressBar = showProgressBar;
        this.isShowAlert = showAlert;
        this.mSubTitle = subTitle;
        this.mPaddingLeft = paddingLeft;
    }

    protected BHMDrawerItem(Parcel in) {
        boolean r0 = false;
        this.mViewType = 0;
        this.mViewType = in.readInt();
        this.mTitle = in.readString();
        this.mIconResId = in.readInt();
        this.mCount = in.readString();
        this.mCountColor = in.readInt();
        if (in.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.isEnabled = r1;
        if (in.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.isShowProgressBar = r2;
        if (in.readByte() == 0) goto L13;
        r0 = true;
    L13:
        this.isShowAlert = r0;
        this.mSubTitle = in.readString();
        this.mPaddingLeft = in.readInt();
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public View getView(View convertView, ViewGroup parent) {
        int r0 = this.mViewType;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "BHMDrawerItem.getView() for custom type=" + this.mViewType);
        return null;
    L11:
        return getHeaderView(convertView, parent);
    L9:
        return getItemView(convertView, parent);
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public BHMDrawerItem setViewType(int type) {
        this.mViewType = type;
        return this;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public BHMDrawerItem setTitle(String title) {
        this.mTitle = title;
        return this;
    }

    public String getSubtitle() {
        return this.mSubTitle;
    }

    public BHMDrawerItem setSubtitle(String subtitle) {
        this.mSubTitle = subtitle;
        return this;
    }

    public String getNumberCount() {
        return this.mCount;
    }

    public BHMDrawerItem setNumberCount(String count) {
        this.mCount = count;
        return this;
    }

    public BHMDrawerItem setIconResId(int id) {
        this.mIconResId = id;
        return this;
    }

    public int getIconResId() {
        return this.mIconResId;
    }

    public BHMDrawerItem setShowProgressBar(boolean show) {
        this.isShowProgressBar = show;
        return this;
    }

    public boolean isShowProgressBar() {
        return this.isShowProgressBar;
    }

    public BHMDrawerItem setShowAlert(boolean show) {
        this.isShowAlert = show;
        return this;
    }

    public boolean isShowAlert() {
        return this.isShowAlert;
    }

    public BHMDrawerItem setCountColor(int color) {
        this.mCountColor = color;
        return this;
    }

    public int getCountColor() {
        return this.mCountColor;
    }

    public BHMDrawerItem setPaddingLeft(int paddingLeft) {
        this.mPaddingLeft = paddingLeft;
        return this;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public boolean calculateEnabled() {
        int r0 = this.mViewType;
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "BHMDrawerItem.isEnabled() for type=" + this.mViewType);
        return true;
    L7:
        return false;
    L9:
        return true;
    }

    private View getHeaderView(View convertView, ViewGroup parent) {
        if (convertView != null) goto L4;
    L6:
        TextView r3 = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.bhm_header_view, parent, false);
    L7:
        r3.setText(this.mTitle);
        return r3;
    L4:
        if ((convertView instanceof TextView) == false) goto L6;
        r3 = (TextView) convertView;
        goto L7
    }

    private View getItemView(View convertView, ViewGroup parent) {
        if (convertView != null) goto L4;
    L6:
        BHMItemView r10 = (BHMItemView) LayoutInflater.from(parent.getContext()).inflate(R.layout.bhm_item_view, null, false);
    L7:
        BHMItemView r0 = r10;
        r0.bind(this.mTitle, this.mIconResId, this.mCount, this.mCountColor, this.isShowProgressBar, this.isShowAlert, this.mSubTitle, this.mPaddingLeft);
        return r10;
    L4:
        if ((convertView instanceof BHMItemView) == false) goto L6;
        r10 = (BHMItemView) convertView;
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mViewType);
        r1.writeString(this.mTitle);
        r1.writeInt(this.mIconResId);
        r1.writeString(this.mCount);
        r1.writeInt(this.mCountColor);
        r1.writeInt(this.isEnabled ? 1 : 0);
        r1.writeInt(this.isShowProgressBar ? 1 : 0);
        r1.writeInt(this.isShowAlert ? 1 : 0);
        r1.writeString(this.mSubTitle);
        r1.writeInt(this.mPaddingLeft);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
