package obric.widget.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.android.contacts.RegionConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import obric.widget.R;
import obric.widget.search.data.GloableSearchConfig;
import obric.widget.search.data.SearchConfigType;
import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: loaded from: classes5.dex */
public class RadioFrameLayout extends FrameLayout {
    private int mCheckedIndex;
    private GloableSearchConfig mConfig;
    private Context mContext;
    private String mCountry;
    private int mItemHeight;
    private int mItemWidth;
    private OnCheckedChangedListener mListener;
    private OptionPopupWindow mPopupWindow;
    private ProgressBar mProgressBar;
    private int mProgressBarHeight;
    private int mProgressBarWidth;
    private List<RadioButton> mRadioBottons;
    private RadioGroup mRadioGroup;
    private List<SearchConfigTypeData> mTypeDataList;

    public interface OnCheckedChangedListener {
        void onCheckedChanged(RadioButton compoundButton, SearchConfigTypeData data);
    }

    static /* synthetic */ int access$000(RadioFrameLayout r0) {
        return r0.mCheckedIndex;
    }

    static /* synthetic */ int access$002(RadioFrameLayout r0, int r1) {
        r0.mCheckedIndex = r1;
        return r1;
    }

    static /* synthetic */ int access$100(RadioFrameLayout r0, RadioButton r1) {
        return r0.getRadioButtonIndex(r1);
    }

    static /* synthetic */ float access$200(RadioFrameLayout r0, int r1) {
        return r0.computeProgressOffset(r1);
    }

    static /* synthetic */ ProgressBar access$300(RadioFrameLayout r0) {
        return r0.mProgressBar;
    }

    static /* synthetic */ void access$400(RadioFrameLayout r0, RadioButton r1) {
        r0.updateSingleRadio(r1);
    }

    static /* synthetic */ OnCheckedChangedListener access$500(RadioFrameLayout r0) {
        return r0.mListener;
    }

    static /* synthetic */ void access$600(RadioFrameLayout r0, RadioButton r1) {
        r0.showPopupWindow(r1);
    }

    static /* synthetic */ void access$700(RadioFrameLayout r0, int r1, SearchConfigTypeData r2) {
        r0.updateTypeList(r1, r2);
    }

    static /* synthetic */ void access$800(RadioFrameLayout r0, int r1) {
        r0.setChecked(r1);
    }

    public RadioFrameLayout(Context context) {
        this(context, null);
    }

    public RadioFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mCountry = Locale.getDefault().getCountry().trim();
        this.mItemWidth = getResources().getDimensionPixelSize(R.dimen.web_search_type_button_width);
        this.mItemHeight = getResources().getDimensionPixelSize(R.dimen.web_search_type_button_height);
        int r1 = getResources().getDimensionPixelSize(R.dimen.web_search_load_progress_size);
        this.mProgressBarWidth = r1;
        this.mProgressBarHeight = r1;
    }

    public void init(GloableSearchConfig config) {
        if (config != null) goto L4;
        return;
    L4:
        this.mConfig = config;
        initView();
    }

    public void setItemHeight(int itemHeight) {
        this.mItemHeight = itemHeight;
    }

    public void setItemWidth(int itemWidth) {
        this.mItemWidth = itemWidth;
    }

    public void setProgressBarHeight(int progressBarHeight) {
        this.mProgressBarHeight = progressBarHeight;
    }

    public void setProgressBarWidth(int progressBarWidth) {
        this.mProgressBarWidth = progressBarWidth;
    }

    public void setCheckedWithSearchType(String searchType) {
        List<SearchConfigType> r0 = this.mConfig.getConfigTypes();
        if (searchType == null) goto L24;
        if (r0 == null) goto L32;
        int r1 = r0.size();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L33;
        SearchConfigType r4 = r0.get(r3);
        if (searchType.equals(r4.getType()) == true) goto L10;
        List<SearchConfigTypeData> r5 = r4.getDatas();
        if (r5 == null) goto L23;
        int r6 = r5.size();
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L23;
        SearchConfigTypeData r8 = r5.get(r7);
        if (r8 == null) goto L22;
        if (searchType.equals(r8.getIdentifier()) == false) goto L22;
        updateTypeList(r7, r8);
        setChecked(r3);
    L22:
        r7 = r7 + 1;
    L23:
        r3 = r3 + 1;
        goto L7
    L10:
        setChecked(r3);
        return;
    L33:
        return;
    L32:
        return;
    }

    public void setCheckedIndex(int index) {
        this.mCheckedIndex = index;
    }

    public int getCheckedIndex() {
        return this.mCheckedIndex;
    }

    public void setChecked() {
        setChecked(this.mCheckedIndex);
    }

    private void setChecked(int rbIndex) {
        int r3 = Math.max(0, rbIndex);
        this.mCheckedIndex = r3;
        int r4 = Math.min(r3, this.mRadioBottons.size() - 1);
        this.mCheckedIndex = r4;
        RadioButton r5 = this.mRadioBottons.get(r4);
        if (r5.isChecked() == false) goto L5;
        this.mRadioGroup.clearCheck();
    L5:
        r5.setChecked(true);
    }

    private void initView() {
        this.mRadioGroup = generateRadioGroup();
        initTypeDataList();
        List<RadioButton> r0 = this.mRadioBottons;
        if (r0 != null) goto L5;
        this.mRadioBottons = new ArrayList();
    L6:
        List<SearchConfigType> r1 = this.mConfig.getConfigTypes();
        int r2 = r1.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        RadioButton r4 = generateSingleRadioButton(r1.get(r3));
        this.mRadioBottons.add(r4);
        this.mRadioGroup.addView(r4, new FrameLayout.LayoutParams(this.mItemWidth, this.mItemHeight));
        r3 = r3 + 1;
        goto L7
    L9:
        addView(this.mRadioGroup, new FrameLayout.LayoutParams(-1, -1));
        ProgressBar r5 = new ProgressBar(this.mContext);
        this.mProgressBar = r5;
        r5.setIndeterminate(false);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.boom_search_loading_progess));
        addView(this.mProgressBar, new FrameLayout.LayoutParams(this.mProgressBarWidth, this.mProgressBarHeight, 19));
        return;
    L5:
        r0.clear();
        goto L6
    }

    private void initTypeDataList() {
        List<SearchConfigTypeData> r0 = this.mTypeDataList;
        if (r0 != null) goto L5;
        this.mTypeDataList = new ArrayList();
    L6:
        List<SearchConfigType> r1 = this.mConfig.getConfigTypes();
        int r2 = r1.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        this.mTypeDataList.add(r1.get(r3).getDefaultData());
        r3 = r3 + 1;
        goto L7
    L9:
        return;
    L5:
        r0.clear();
        goto L6
    }

    private RadioGroup generateRadioGroup() {
        RadioGroup r0 = new RadioGroup(this.mContext);
        r0.setOrientation(0);
        r0.setOnCheckedChangeListener(new AnonymousClass1(this));
        return r0;
    }

    private RadioButton generateSingleRadioButton(SearchConfigType type) {
        RadioButton r0 = new RadioButton(this.mContext);
        SearchConfigTypeData r3 = type.getDefaultData();
        r0.setButtonDrawable(WebSearchUtils.getBoomIconDrawable(this.mContext, r3));
        r0.setContentDescription(getTypeName(r3));
        r0.setBackgroundResource(R.drawable.boom_win_search_more_bg);
        r0.setOnLongClickListener(new AnonymousClass2(this));
        return r0;
    }

    private float computeProgressOffset(int index) {
        int r0 = this.mItemWidth;
        return (index * r0) + ((r0 / 2) - (this.mProgressBarWidth / 2));
    }

    public void setProgressValue(int progress) {
        ProgressBar r1 = this.mProgressBar;
        if (progress >= 100) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private void showPopupWindow(final RadioButton anchorView) {
        final int r0 = getRadioButtonIndex(anchorView);
        List<SearchConfigTypeData> r1 = this.mConfig.getConfigTypes().get(r0).getDatas();
        SearchConfigTypeData r2 = this.mTypeDataList.get(r0);
        OptionPopupWindow r3 = new OptionPopupWindow(this.mContext, r1, r2, new AnonymousClass3(this, anchorView, r0));
        this.mPopupWindow = r3;
        r3.show(anchorView);
    }

    private int getRadioButtonIndex(RadioButton radioButton) {
        return this.mRadioBottons.indexOf(radioButton);
    }

    private void updateTypeList(int index, SearchConfigTypeData data) {
        List<SearchConfigTypeData> r0 = this.mTypeDataList;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= index) goto L10;
        this.mTypeDataList.remove(index);
        this.mTypeDataList.add(index, data);
        return;
    }

    private void updateSingleRadio(RadioButton rb) {
        SearchConfigTypeData r0 = getSearchTypeData();
        if (r0 != null) goto L5;
        return;
    L5:
        rb.setButtonDrawable(WebSearchUtils.getBoomIconDrawable(this.mContext, r0));
        rb.setContentDescription(getTypeName(r0));
    }

    private String getTypeName(SearchConfigTypeData searchType) {
        String r3 = this.mCountry;
        int r0 = r3.hashCode();
        if (r0 == 2155) goto L16;
        if (r0 == 2691) goto L13;
        if (r0 == 2718) goto L10;
    L18:
        byte r4 = -1;
    L19:
        if (r4 == 0) goto L26;
        if (r4 == 1) goto L24;
        return searchType.getName();
    L24:
        return searchType.getTwName();
    L26:
        return searchType.getEnName();
    L10:
        if (r3.equals("US") == false) goto L18;
        r4 = 0;
        goto L19
    L13:
        if (r3.equals("TW") == false) goto L18;
        r4 = 1;
        goto L19
    L16:
        if (r3.equals(RegionConstants.REGION) == false) goto L18;
        r4 = 2;
        goto L19
    }

    public void reset() {
        OptionPopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        initTypeDataList();
        this.mRadioGroup.clearCheck();
        this.mCheckedIndex = 0;
    }

    public SearchConfigTypeData getSearchTypeData() {
        return this.mTypeDataList.get(this.mCheckedIndex);
    }

    public List<SearchConfigTypeData> getTypeDataList() {
        return this.mTypeDataList;
    }

    public void setOnCheckedChangedListener(OnCheckedChangedListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) goto L8;
        OptionPopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L9;
        r0.hide();
        return;
    L9:
        return;
    }
}
