package com.amap.api.mapcore.util;

import android.app.Dialog;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class z4 implements OfflineMapManager.OfflineMapDownloadListener, OfflineMapManager.OfflineLoadedListener, View.OnTouchListener, TextWatcher, AbsListView.OnScrollListener {
    private w4 A;
    private boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected OfflineMapActivity f28559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f28560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RelativeLayout f28561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f28562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DownLoadExpandListView f28563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ListView f28564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExpandableListView f28565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f28566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f28567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f28568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AutoCompleteTextView f28569k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RelativeLayout f28570l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RelativeLayout f28571m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f28572n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f28573o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RelativeLayout f28574p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f28575q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<OfflineMapProvince> f28576r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private u4 f28577s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private OfflineMapManager f28578t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private t4 f28579u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private v4 f28580v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f28581w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f28582x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f28583y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f28584z;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z4 f28585a;

        public a(z4 r100) {
            this.f28585a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            z4.a(this.f28585a).setText("");     // Catch: Exception -> L4
            z4.b(this.f28585a).setVisibility(8);     // Catch: Exception -> L4
            this.f28585a.a(false);     // Catch: Exception -> L4
            RelativeLayout.LayoutParams r101 = (RelativeLayout.LayoutParams) z4.c(this.f28585a).getLayoutParams();     // Catch: Exception -> L4
            r101.leftMargin = this.f28585a.a(95.0f);     // Catch: Exception -> L4
            z4.c(this.f28585a).setLayoutParams(r101);     // Catch: Exception -> L4
            z4.a(this.f28585a).setPadding(this.f28585a.a(105.0f), 0, 0, 0);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class b implements Comparator<OfflineMapCity> {
        public b(z4 r100) {
        }

        @Override // java.util.Comparator
        public int compare(OfflineMapCity r100, OfflineMapCity r101) {
            char[] r102 = r100.getJianpin().toCharArray();
            char[] r103 = r101.getJianpin().toCharArray();
            if (r102[0] >= r103[0]) goto L6;
        L7:
            return 1;
        L6:
            if (r102[1] < r103[1]) goto L7;
            return 0;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onCheckUpdate(boolean r100, String r101) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r100, int r101, int r102, int r103) {
    }

    private void c() {
        ArrayList<OfflineMapProvince> r100 = this.f28578t.getOfflineMapProvinceList();
        this.f28576r.clear();
        this.f28576r.add(null);
        ArrayList<OfflineMapCity> r101 = new ArrayList();
        ArrayList<OfflineMapCity> r102 = new ArrayList();
        int r103 = 0;
    L4:
        if (r103 >= r100.size()) goto L23;
        OfflineMapProvince r104 = (OfflineMapProvince) ListProtector.get(r100, r103);
        String r105 = r104.getProvinceName();
        int r106 = r104.getCityList().size();
        if (r105.contains(p0.a(2131034184)) == false) goto L8;
    L19:
        if (r106 <= 0) goto L21;
        r102.addAll(r104.getCityList());
    L22:
        r103 = r103 + 1;
        goto L4
    L21:
        OfflineMapCity r107 = new OfflineMapCity();
        r107.setCity(r105);
        r107.setSize(r104.getSize());
        r107.setAdcode(r104.getProvinceCode());
        r107.setUrl(r104.getUrl());
        r102.add(r107);
        goto L22
    L8:
        if (r105.contains(p0.a(2131034185)) == true) goto L19;
        if (r105.contains(p0.a(2131034131)) == true) goto L19;
        if (r105.contains("全国概要图") == false) goto L16;
        r101.addAll(0, r104.getCityList());
        goto L22
    L16:
        if (r106 > 1) goto L18;
        r101.addAll(r104.getCityList());
        goto L22
    L18:
        this.f28576r.add(r104);
        goto L22
    L23:
        OfflineMapProvince r108 = new OfflineMapProvince();
        r108.setProvinceName(p0.a(R.bool.workmanager_test_configuration));
        r108.setCityList(r101);
        ListProtector.set(this.f28576r, 0, r108);
        OfflineMapProvince r109 = new OfflineMapProvince();
        r109.setProvinceName(p0.a(2131034186));
        r109.setCityList(r102);
        this.f28576r.add(r109);
    }

    public boolean a() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return true;
    L3:
        if (this.f28564f.getVisibility() != 0) goto L12;
        this.f28569k.setText("");     // Catch: Exception -> L6
        this.f28572n.setVisibility(8);     // Catch: Exception -> L6
        a(false);     // Catch: Exception -> L6
        return false;
    L12:
        return true;
    }

    public RelativeLayout b() {
        if (this.f28561c != null) goto L6;
        this.f28561c = (RelativeLayout) b5.a(this.f28559a, R.array.branch_string_array, null);
    L6:
        return this.f28561c;
    }

    public void d() {
        this.f28578t.destroy();
    }

    public void e() {
        View r100 = b5.a(this.f28559a, R.array.appease_text, null);
        DownLoadExpandListView r101 = (DownLoadExpandListView) r100.findViewById(2147479557);
        this.f28563e = r101;
        r101.setOnTouchListener(this);
        this.f28570l = (RelativeLayout) r100.findViewById(2147479554);
        this.f28567i = (ImageView) r100.findViewById(2147479556);
        this.f28570l.setOnClickListener(this.f28559a);
        this.f28571m = (RelativeLayout) r100.findViewById(2147479559);
        TextView r102 = (TextView) r100.findViewById(2147479560);
        this.f28566h = r102;
        r102.setText(p0.a(R.bool.ttlive_with_plus_prefix));
        this.f28568j = (ImageView) r100.findViewById(2147479561);
        this.f28571m.setOnClickListener(this.f28559a);
        this.f28574p = (RelativeLayout) r100.findViewById(2147479558);
        TextView r103 = (TextView) r100.findViewById(2147479555);
        this.f28575q = r103;
        r103.setText(p0.a(R.bool.sva_support_stage2_by_pass));
        ((TextView) r100.findViewById(2147479555)).setText(p0.a(2131034336));
        ImageView r104 = (ImageView) this.f28561c.findViewById(2147479576);
        this.f28560b = r104;
        r104.setOnClickListener(this.f28559a);
        TextView r105 = (TextView) this.f28561c.findViewById(2147479577);
        this.f28562d = r105;
        r105.setText(p0.a(2131034132));
        this.f28573o = (ImageView) this.f28561c.findViewById(2147479578);
        ImageView r106 = (ImageView) this.f28561c.findViewById(2147479580);
        this.f28572n = r106;
        r106.setOnClickListener(new a(this));
        this.f28561c.findViewById(2147479581).setOnTouchListener(this);
        AutoCompleteTextView r107 = (AutoCompleteTextView) this.f28561c.findViewById(2147479579);
        this.f28569k = r107;
        r107.addTextChangedListener(this);
        this.f28569k.setOnTouchListener(this);
        this.f28564f = (ListView) this.f28561c.findViewById(2147479583);
        ExpandableListView r108 = (ExpandableListView) this.f28561c.findViewById(2147479582);
        this.f28565g = r108;
        r108.addHeaderView(r100);
        this.f28565g.setOnTouchListener(this);
        this.f28565g.setOnScrollListener(this);
        OfflineMapManager r109 = new OfflineMapManager(this.f28559a, this);     // Catch: Exception -> L5
        this.f28578t = r109;     // Catch: Exception -> L5
        r109.setOnOfflineLoadedListener(this);     // Catch: Exception -> L5
    L7:
        c();
        u4 r110 = new u4(this.f28576r, this.f28578t, this.f28559a);
        this.f28577s = r110;
        this.f28565g.setAdapter(r110);
        this.f28565g.setOnGroupCollapseListener(this.f28577s);
        this.f28565g.setOnGroupExpandListener(this.f28577s);
        this.f28565g.setGroupIndicator(null);
        if (this.f28581w == false) goto L10;
        this.f28568j.setBackgroundResource(R.animator.aos_profile_ic_back_anim);
        this.f28565g.setVisibility(0);
    L12:
        if (this.f28582x == false) goto L14;
        this.f28567i.setBackgroundResource(R.animator.aos_profile_ic_back_anim);
        this.f28563e.setVisibility(0);
        return;
    L14:
        this.f28567i.setBackgroundResource(R.animator.button_press_animator);
        this.f28563e.setVisibility(8);
        return;
    L10:
        this.f28568j.setBackgroundResource(R.animator.button_press_animator);
        this.f28565g.setVisibility(8);
    L5:
        e = move-exception;
        e.toString();
        goto L7
    }

    public z4() {
        this.f28559a = null;
        this.f28576r = new ArrayList();
        this.f28578t = null;
        this.f28581w = true;
        this.f28582x = true;
        this.f28583y = -1;
        this.f28584z = 0;
        this.B = true;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public void onVerifyComplete() {
        c();
        v4 r100 = new v4(this.f28578t, this.f28559a);
        this.f28580v = r100;
        this.f28564f.setAdapter(r100);
        t4 r101 = new t4(this.f28559a, this, this.f28578t, this.f28576r);
        this.f28579u = r101;
        this.f28563e.setAdapter(r101);
        this.f28579u.notifyDataSetChanged();
    }

    public static void INVOKEVIRTUAL_com_amap_api_mapcore_util_z4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_z4_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ ImageView b(z4 r100) {
        return r100.f28572n;
    }

    public static /* synthetic */ ImageView c(z4 r100) {
        return r100.f28573o;
    }

    public void a(View r100) {
        int r101 = r100.getId();     // Catch: Exception -> L18
        if (r101 != 2147479576) goto L6;
        this.f28559a.closeScr();     // Catch: Exception -> L18
    L21:
        return;
    L6:
        if (r101 != 2147479554) goto L12;
        if (this.f28582x == false) goto L10;
        this.f28563e.setVisibility(8);     // Catch: Exception -> L18
        this.f28567i.setBackgroundResource(R.animator.button_press_animator);     // Catch: Exception -> L18
        this.f28582x = false;     // Catch: Exception -> L18
        goto L21
    L10:
        this.f28563e.setVisibility(0);     // Catch: Exception -> L18
        this.f28567i.setBackgroundResource(R.animator.aos_profile_ic_back_anim);     // Catch: Exception -> L18
        this.f28582x = true;     // Catch: Exception -> L18
        goto L21
    L12:
        if (r101 != 2147479559) goto L21;
        if (this.f28581w == false) goto L16;
        this.f28577s.a();     // Catch: Exception -> L18
        this.f28568j.setBackgroundResource(R.animator.button_press_animator);     // Catch: Exception -> L18
        this.f28581w = false;     // Catch: Exception -> L18
        goto L21
    L16:
        this.f28577s.b();     // Catch: Exception -> L18
        this.f28568j.setBackgroundResource(R.animator.aos_profile_ic_back_anim);     // Catch: Exception -> L18
        this.f28581w = true;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public void a(boolean r100) {
        int r101 = 0;
        if (r100 == false) goto L5;
        this.f28570l.setVisibility(8);
        this.f28571m.setVisibility(8);
        this.f28563e.setVisibility(8);
        this.f28565g.setVisibility(8);
        this.f28574p.setVisibility(8);
        this.f28564f.setVisibility(0);
        return;
    L5:
        this.f28570l.setVisibility(0);
        this.f28571m.setVisibility(0);
        this.f28574p.setVisibility(0);
        DownLoadExpandListView r102 = this.f28563e;
        if (this.f28582x == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        ExpandableListView r104 = this.f28565g;
        if (this.f28581w == true) goto L13;
        r101 = 8;
    L13:
        r104.setVisibility(r101);
        this.f28564f.setVisibility(8);
        return;
    L8:
        r103 = 8;
        goto L9
    }

    public void a(OfflineMapCity r100) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.A != null) goto L5;
        this.A = new w4(this.f28559a, this.f28578t);     // Catch: Exception -> L7
    L5:
        this.A.a(r100.getState(), r100.getCity());     // Catch: Exception -> L7
        INVOKEVIRTUAL_com_amap_api_mapcore_util_z4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.A);     // Catch: Exception -> L7
    }

    public int a(float r100) {
        OfflineMapActivity r101 = this.f28559a;
        if (r101 == null) goto L7;
        return (int) ((r100 * (INVOKEVIRTUAL_com_amap_api_mapcore_util_z4_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()).densityDpi / 160.0f)) + 0.5f);
    L7:
        return (int) r100;
    }

    public static /* synthetic */ AutoCompleteTextView a(z4 r100) {
        return r100.f28569k;
    }

    public void a(OfflineMapActivity r100) {
        this.f28559a = r100;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r100, int r101) {
        if (r101 != 2) goto L5;
        this.B = false;
        return;
    L5:
        this.B = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r100, MotionEvent r101) {
        AutoCompleteTextView r102 = this.f28569k;
        if (r102 == null) goto L13;
        if (r102.isFocused() == false) goto L13;
        this.f28569k.clearFocus();
        InputMethodManager r103 = (InputMethodManager) this.f28559a.getSystemService("input_method");
        if (r103 == null) goto L9;
        boolean r104 = r103.isActive();
    L10:
        if (r104 == false) goto L13;
        r103.hideSoftInputFromWindow(this.f28569k.getWindowToken(), 2);
        goto L13
    L9:
        r104 = false;
    L13:
        if (r100.getId() == 2147479579) goto L19;
    L18:
        return false;
    L19:
        RelativeLayout.LayoutParams r105 = (RelativeLayout.LayoutParams) this.f28573o.getLayoutParams();     // Catch: Exception -> L16
        r105.leftMargin = a(18.0f);     // Catch: Exception -> L16
        this.f28573o.setLayoutParams(r105);     // Catch: Exception -> L16
        this.f28569k.setPadding(a(30.0f), 0, 0, 0);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onDownload(int r100, int r101, String r102) {
        if (r100 != 101) goto L7;
        Toast.makeText(this.f28559a, p0.a(2131034400), 0).show();     // Catch: Exception -> L28
        this.f28578t.pause();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r100 != 2) goto L10;
        this.f28579u.b();     // Catch: Exception -> L28
    L10:
        if (this.f28583y == r100) goto L22;
        u4 r103 = this.f28577s;     // Catch: Exception -> L28
        if (r103 == null) goto L14;
        r103.notifyDataSetChanged();     // Catch: Exception -> L28
    L14:
        t4 r104 = this.f28579u;     // Catch: Exception -> L28
        if (r104 == null) goto L17;
        r104.notifyDataSetChanged();     // Catch: Exception -> L28
    L17:
        v4 r105 = this.f28580v;     // Catch: Exception -> L28
        if (r105 == null) goto L20;
        r105.notifyDataSetChanged();     // Catch: Exception -> L28
    L20:
        this.f28583y = r100;     // Catch: Exception -> L28
        return;
    L22:
        if ((System.currentTimeMillis() - this.f28584z) > 1200) goto L24;
        return;
    L24:
        if (this.B == false) goto L26;
        this.f28579u.notifyDataSetChanged();     // Catch: Exception -> L28
    L26:
        this.f28584z = System.currentTimeMillis();     // Catch: Exception -> L28
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onRemove(boolean r100, String r101, String r102) {
        t4 r103 = this.f28579u;
        if (r103 == null) goto L6;
        r103.a();
        return;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r100, int r101, int r102, int r110) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        a(false);
        this.f28572n.setVisibility(8);
        return;
    L6:
        this.f28572n.setVisibility(0);
        ArrayList r103 = new ArrayList();
        List<OfflineMapProvince> r111 = this.f28576r;
        if (r111 == null) goto L30;
        if (r111.size() <= 0) goto L30;
        ArrayList r112 = new ArrayList();
        Iterator<OfflineMapProvince> r104 = this.f28576r.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r112.addAll(r104.next().getCityList());
        goto L12
    L14:
        Iterator r113 = r112.iterator();
    L16:
        if (r113.hasNext() == false) goto L30;
        OfflineMapCity r105 = (OfflineMapCity) r113.next();
        String r106 = r105.getCity();
        String r107 = r105.getPinyin();
        String r108 = r105.getJianpin();
        if (r100.length() == 1) goto L20;
        if (r108.startsWith(String.valueOf(r100)) == true) goto L28;
        if (r107.startsWith(String.valueOf(r100)) == true) goto L28;
        if (r106.startsWith(String.valueOf(r100)) == false) goto L16;
    L28:
        r103.add(r105);
        goto L16
    L20:
        if (r108.startsWith(String.valueOf(r100)) == false) goto L16;
        r103.add(r105);
    L30:
        if (r103.size() <= 0) goto L34;
        a(true);
        Collections.sort(r103, new b(this));
        v4 r109 = this.f28580v;
        if (r109 == null) goto L49;
        r109.a(r103);
        this.f28580v.notifyDataSetChanged();
        return;
    L49:
        return;
    L34:
        Toast.makeText(this.f28559a, p0.a(2131034399), 0).show();
    }
}
