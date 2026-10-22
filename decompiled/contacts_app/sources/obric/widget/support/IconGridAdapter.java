package obric.widget.support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.List;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class IconGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<Drawable> mIcons;

    class ViewHolder {
        ImageView icon;
        final /* synthetic */ IconGridAdapter this$0;

        ViewHolder(final IconGridAdapter this$0) {
            this.this$0 = this$0;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public IconGridAdapter(Context context, List<Drawable> icons) {
        this.mContext = context;
        this.mIcons = icons;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Drawable> r0 = this.mIcons;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) goto L4;
        ViewHolder r5 = new ViewHolder(this);
        View r6 = LayoutInflater.from(this.mContext).inflate(R.layout.icon_grid_menu_item, null);
        r5.icon = (ImageView) r6.findViewById(R.id.icon);
        r6.setTag(r5);
    L5:
        r5.icon.setImageDrawable(this.mIcons.get(position));
        return r6;
    L4:
        ViewHolder r7 = (ViewHolder) convertView.getTag();
        r6 = convertView;
        r5 = r7;
        goto L5
    }
}
