package obric.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BottomMenuPopupAdapter extends BaseAdapter {
    private static final int MAX_LENGTH = 6;
    public static final int MIDLE_BOTTOM_ITEM = 2;
    private static final int ORIGINAL_TEXTSIZE_SP = 12;
    public static final int RIGHT_BOTTOTM_ITEM = 1;
    public static final int TOP_ITEM = 0;
    private int mChildHeight;
    private Context mContext;
    private LayoutInflater mInflater;
    private List<MenuItem> mItems;
    public int mType;

    public interface ItemPressStateListener {
        void onItemPressStateChanged(int position, boolean pressed);
    }

    private static class ViewHolder {
        ImageView mIcon;
        TextView mTvTitle;

        public ViewHolder(View v, BottomMenuPopupAdapter adapter) {
            this.mIcon = (ImageView) v.findViewById(R.id.menu_icon);
            this.mTvTitle = (TextView) v.findViewById(R.id.menu_text);
            v.setTag(this);
        }
    }

    protected void bindViewCustom(ImageView icon, TextView title, int position) {
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int position) {
        return getItem(position);
    }

    public BottomMenuPopupAdapter(Context context, List<MenuItem> items) {
        this.mType = 0;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mItems = items;
        this.mContext = context;
    }

    private void bindView(View convertView, int position) {
        MenuItem r0 = getItem(position);
        ViewHolder r6 = (ViewHolder) convertView.getTag();
        boolean r1 = isEnabled(position);
        int r2 = R.color.menu_text_color;
        r6.mIcon.setImageDrawable(r0.getIcon());
        r6.mTvTitle.setText(r0.getTitle());
        r6.mTvTitle.setTextColor(this.mContext.getResources().getColor(r2));
        r6.mIcon.setEnabled(r1);
        bindViewCustom(r6.mIcon, r6.mTvTitle, position);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) goto L9;
        convertView = this.mInflater.inflate(R.layout.menu_list_item, parent, false);
        int r5 = this.mChildHeight;
        if (r5 != 0) goto L6;
    L8:
        createHolder(convertView);
        goto L9
    L6:
        if (r5 == (-1)) goto L8;
        ViewGroup.LayoutParams r6 = convertView.getLayoutParams();
        r6.height = this.mChildHeight;
    L9:
        bindView(convertView, position);
        return convertView;
    }

    private void createHolder(View convertView) {
        convertView.setTag(new ViewHolder(convertView, this));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    public Object getItems() {
        return this.mItems;
    }

    public boolean isItemCheck(int position) {
        return this.mItems.get(position).isChecked();
    }

    @Override // android.widget.Adapter
    public MenuItem getItem(int position) {
        return this.mItems.get(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        return this.mItems.get(position).isEnabled();
    }

    public void setChildHeight(int childHeight) {
        this.mChildHeight = childHeight;
    }

    public static int dip2px(Context context, double dipValue) {
        return (int) ((dipValue * ((double) context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int getCompatibilityStatusBarHeight(Context context) {
        int r0 = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return context.getResources().getDimensionPixelSize(r0);
    }
}
