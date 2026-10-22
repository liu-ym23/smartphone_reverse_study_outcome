package com.bytedance.reparo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.reparo.core.k;
import com.bytedance.reparo.core.m;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ReparoInfoActivity extends GeneratePluginActivity implements k.a {
    private ArrayList<com.bytedance.reparo.core.h.d> localPatches;
    private PatchInfoAdapter mAdapter;
    private Handler mHandler;

    class PatchInfoAdapter extends BaseAdapter {
        final /* synthetic */ ReparoInfoActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        PatchInfoAdapter(ReparoInfoActivity r3) {
            this.this$0 = (ReparoInfoActivity) ZeusTransformUtils.wrapperContextForParams(r3, ReparoInfoActivity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ReparoInfoActivity.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return ReparoInfoActivity.access$000(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 == null) goto L5;
            a r8 = (a) ZeusTransformUtils.preCheckCast(r6.getTag(), a.class, "com.obric.aiagent.plugin");
        L6:
            com.bytedance.reparo.core.g.h r4 = ((com.bytedance.reparo.core.h.d) ZeusTransformUtils.preCheckCast(ReparoInfoActivity.access$000(this.this$0).get(r5), com.bytedance.reparo.core.h.d.class, "com.obric.aiagent.plugin")).g();
            r8.f9092a.setText(r4.n());
            r8.f9093b.setText(r4.m());
            r8.f9094c.setText(r4.c());
            return r6;
        L5:
            r6 = ZeusTransformUtils.inflate(this.this$0.getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.reparo_info_item, "layout", "reparo_info_item"), r7, false, "com.obric.aiagent.plugin");
            r8 = new a(this.this$0);
            r6.setTag(r8);
            r8.f9092a = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.reparo_patch_id, DbHelper.COL_ID, "reparo_patch_id")), TextView.class, "com.obric.aiagent.plugin");
            r8.f9093b = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.reparo_patch_version, DbHelper.COL_ID, "reparo_patch_version")), TextView.class, "com.obric.aiagent.plugin");
            r8.f9094c = (TextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.reparo_patch_install_dir, DbHelper.COL_ID, "reparo_patch_install_dir")), TextView.class, "com.obric.aiagent.plugin");
            goto L6
        }
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f9092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f9093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TextView f9094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ReparoInfoActivity f9095d;

        a(ReparoInfoActivity r3) {
            this.f9095d = (ReparoInfoActivity) ZeusTransformUtils.wrapperContextForParams(r3, ReparoInfoActivity.class, "com.obric.aiagent.plugin");
        }
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public ReparoInfoActivity() {
        this.localPatches = new ArrayList();
        this.mHandler = new Handler();
    }

    static /* synthetic */ ArrayList access$000(ReparoInfoActivity r2) {
        return ((ReparoInfoActivity) ZeusTransformUtils.wrapperContextForParams(r2, ReparoInfoActivity.class, "com.obric.aiagent.plugin")).localPatches;
    }

    static /* synthetic */ PatchInfoAdapter access$100(ReparoInfoActivity r2) {
        return ((ReparoInfoActivity) ZeusTransformUtils.wrapperContextForParams(r2, ReparoInfoActivity.class, "com.obric.aiagent.plugin")).mAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r4) {
        super/*android.app.Activity*/.onCreate(r4);
        setContentView(ZeusTransformUtils.mapRes(R.layout.reparo_info, "layout", "reparo_info"));
        if (g.a().f() == true) goto L5;
        findViewById(ZeusTransformUtils.mapRes(R.id.reparo_error_msg, DbHelper.COL_ID, "reparo_error_msg")).setVisibility(0);
        findViewById(ZeusTransformUtils.mapRes(R.id.reparo_info_container, DbHelper.COL_ID, "reparo_info_container")).setVisibility(8);
        return;
    L5:
        Map<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> r5 = m.a().d();
        m.a().a(this);
        this.localPatches.clear();
        this.localPatches.addAll(r5.values());
        ListView r6 = (ListView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.reparo_info_list, DbHelper.COL_ID, "reparo_info_list")), ListView.class, "com.obric.aiagent.plugin");
        PatchInfoAdapter r1 = new PatchInfoAdapter(this);
        this.mAdapter = r1;
        r6.setAdapter(r1);
        findViewById(ZeusTransformUtils.mapRes(R.id.reparo_fetch_patchs, DbHelper.COL_ID, "reparo_fetch_patchs")).setOnClickListener(new AnonymousClass1(this));
        findViewById(ZeusTransformUtils.mapRes(R.id.reparo_clear_patchs, DbHelper.COL_ID, "reparo_clear_patchs")).setOnClickListener(new AnonymousClass2(this));
    }

    @Override // com.bytedance.reparo.core.k.a
    public void onChanged(ConcurrentHashMap<com.bytedance.reparo.core.g.h, com.bytedance.reparo.core.h.d> r2) {
        this.mHandler.post(new AnonymousClass3(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        if (g.a().f() == false) goto L6;
        m.a().b(this);
        return;
    }
}
