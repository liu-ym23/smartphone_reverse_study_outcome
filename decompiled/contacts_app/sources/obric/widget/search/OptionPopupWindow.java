package obric.widget.search;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.contacts.RegionConstants;
import com.android.contacts.numberassistant.MarkInfoUtil;
import java.util.List;
import java.util.Locale;
import obric.InvokeApi;
import obric.widget.R;
import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: loaded from: classes5.dex */
public class OptionPopupWindow {
    private SearchConfigTypeData mChooseData;
    private List<SearchConfigTypeData> mConfigList;
    private int mContentViewHeight;
    private int mContentViewWidth;
    private String mCountry;
    private LayoutInflater mInflater;
    private onChooseChangedListener mListener;
    private PopupWindow mPopupWindow;

    /* JADX INFO: renamed from: obric.widget.search.OptionPopupWindow$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class OptionAdapter extends BaseAdapter {
        final /* synthetic */ OptionPopupWindow this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        private OptionAdapter(final OptionPopupWindow this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ OptionAdapter(OptionPopupWindow r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OptionPopupWindow.access$100(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        @Override // android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            final boolean r0 = false;
            if (convertView != null) goto L5;
            convertView = OptionPopupWindow.access$200(this.this$0).inflate(R.layout.search_option_listitem, parent, false);
            ViewHolder r6 = new ViewHolder(this.this$0, null);
            r6.mIconImageView = (ImageView) convertView.findViewById(R.id.search_item_icon);
            r6.mTextView = (TextView) convertView.findViewById(R.id.search_item_text);
            r6.mCheckedImageView = (ImageView) convertView.findViewById(R.id.search_item_check);
            convertView.setTag(r6);
        L6:
            final SearchConfigTypeData r4 = (SearchConfigTypeData) OptionPopupWindow.access$100(this.this$0).get(position);
            if (r4 != null) goto L9;
        L12:
            return convertView;
        L9:
            if (r4 != OptionPopupWindow.access$400(this.this$0)) goto L11;
            r0 = true;
        L11:
            r6.mIconImageView.setBackground(WebSearchUtils.getBoomIconDrawable(convertView.getContext(), r4));
            r6.mTextView.setText(getTypeName(OptionPopupWindow.access$500(this.this$0), r4));
            r6.mCheckedImageView.setSelected(r0);
            convertView.setOnClickListener(new AnonymousClass1(this, r0, r4));
            goto L12
        L5:
            r6 = (ViewHolder) convertView.getTag();
            goto L6
        }

        private String getTypeName(String country, SearchConfigTypeData searchType) {
            int r2 = country.hashCode();
            if (r2 == 2155) goto L16;
            if (r2 == 2691) goto L13;
            if (r2 == 2718) goto L10;
        L18:
            byte r3 = -1;
        L19:
            if (r3 == 0) goto L26;
            if (r3 == 1) goto L24;
            return searchType.getName();
        L24:
            return searchType.getTwName();
        L26:
            return searchType.getEnName();
        L10:
            if (country.equals("US") == false) goto L18;
            r3 = 0;
            goto L19
        L13:
            if (country.equals("TW") == false) goto L18;
            r3 = 1;
            goto L19
        L16:
            if (country.equals(RegionConstants.REGION) == false) goto L18;
            r3 = 2;
            goto L19
        }
    }

    private class ViewHolder {
        ImageView mCheckedImageView;
        ImageView mIconImageView;
        TextView mTextView;
        final /* synthetic */ OptionPopupWindow this$0;

        private ViewHolder(final OptionPopupWindow this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ ViewHolder(OptionPopupWindow r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public interface onChooseChangedListener {
        void onChoosedChanged(View view, SearchConfigTypeData data);
    }

    static /* synthetic */ List access$100(OptionPopupWindow r0) {
        return r0.mConfigList;
    }

    static /* synthetic */ LayoutInflater access$200(OptionPopupWindow r0) {
        return r0.mInflater;
    }

    static /* synthetic */ SearchConfigTypeData access$400(OptionPopupWindow r0) {
        return r0.mChooseData;
    }

    static /* synthetic */ String access$500(OptionPopupWindow r0) {
        return r0.mCountry;
    }

    static /* synthetic */ onChooseChangedListener access$600(OptionPopupWindow r0) {
        return r0.mListener;
    }

    static /* synthetic */ PopupWindow access$700(OptionPopupWindow r0) {
        return r0.mPopupWindow;
    }

    public OptionPopupWindow(Context context, List<SearchConfigTypeData> configList, SearchConfigTypeData chooseData, onChooseChangedListener listener) {
        this.mConfigList = configList;
        this.mChooseData = chooseData;
        this.mListener = listener;
        this.mCountry = Locale.getDefault().getCountry().trim();
        PopupWindow r2 = new PopupWindow(context);
        this.mPopupWindow = r2;
        r2.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setInputMethodMode(2);
        this.mPopupWindow.setFocusable(false);
        this.mPopupWindow.setClippingEnabled(false);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        this.mPopupWindow.setOverlapAnchor(true);
        this.mPopupWindow.setAnimationStyle(InvokeApi.xComAndroidInternalR.getResId("style", "Animation_DropDownUp"));
        LayoutInflater r1 = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mInflater = r1;
        View r3 = r1.inflate(R.layout.search_option_popup, null);
        this.mPopupWindow.setContentView(r3);
        ((ListView) r3.findViewById(R.id.search_option_listview)).setAdapter(new OptionAdapter(this, null));
    }

    private void measureView(View view) {
        int r2 = View.MeasureSpec.makeMeasureSpec(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST, Integer.MIN_VALUE);
        view.measure(View.MeasureSpec.makeMeasureSpec(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST, Integer.MIN_VALUE), r2);
        this.mContentViewWidth = view.getMeasuredWidth();
        this.mContentViewHeight = view.getMeasuredHeight();
    }

    public void show(View view) {
        if (this.mPopupWindow.isShowing() == true) goto L6;
        measureView(this.mPopupWindow.getContentView());
        int[] r1 = new int[2];
        view.getLocationInWindow(r1);
        int r3 = r1[0] + ((view.getMeasuredWidth() - this.mContentViewWidth) / 2);
        int r0 = r1[1] - this.mContentViewHeight;
        int r2 = Math.max(r3, 0);
        this.mPopupWindow.showAtLocation(view, 0, r2, r0);
        return;
    }

    public void hide() {
        this.mPopupWindow.dismiss();
    }
}
