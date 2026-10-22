package com.stepos.agentframework.util;

import La.H;
import Z8.C1173v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.core.view.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/util/AgentImagePreviewActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Ljava/util/List;", "Lcom/stepos/agentframework/util/u;", "previewHelper", "Lcom/stepos/agentframework/util/u;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentImagePreviewActivity extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_IMAGE_SOURCES = "com.stepos.agentframework.extra.IMAGE_SOURCES";
    public static final String EXTRA_LOCAL_PATHS = "com.stepos.agentframework.extra.LOCAL_PATHS";
    public static final String EXTRA_SHOW_TITLE_BAR = "com.stepos.agentframework.extra.SHOW_TITLE_BAR";
    public static final String EXTRA_START_POSITION = "com.stepos.agentframework.extra.START_POSITION";
    private u previewHelper;
    private List<String> sources = C1173v.m();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/util/AgentImagePreviewActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "position", "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "", "showTitleBar", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;ILjava/util/List;Z)V", "EXTRA_IMAGE_SOURCES", "Ljava/lang/String;", "EXTRA_START_POSITION", "EXTRA_SHOW_TITLE_BAR", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.util.AgentImagePreviewActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, int i10, List list, boolean z10, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                z10 = false;
            }
            companion.a(context, i10, list, z10);
        }

        public final void a(Context context, int position, List<String> sources, boolean showTitleBar) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(sources, "sources");
            if (sources.isEmpty()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) AgentImagePreviewActivity.class);
            intent.putStringArrayListExtra(AgentImagePreviewActivity.EXTRA_IMAGE_SOURCES, new ArrayList<>(sources));
            intent.putExtra(AgentImagePreviewActivity.EXTRA_START_POSITION, position);
            intent.putExtra(AgentImagePreviewActivity.EXTRA_SHOW_TITLE_BAR, showTitleBar);
            if (!(context instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(intent);
        }

        public Companion() {
        }
    }

    public static final Y8.t s(AgentImagePreviewActivity agentImagePreviewActivity) {
        agentImagePreviewActivity.finish();
        agentImagePreviewActivity.overridePendingTransition(0, 0);
        return Y8.t.f7040a;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Y.b(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.type = 2010;
        getWindow().setAttributes(attributes);
        Iterable stringArrayListExtra = getIntent().getStringArrayListExtra(EXTRA_IMAGE_SOURCES);
        if (stringArrayListExtra == null) {
            stringArrayListExtra = C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : stringArrayListExtra) {
            String str = (String) obj;
            kotlin.jvm.internal.p.f(str);
            if (!H.x0(str)) {
                arrayList.add(obj);
            }
        }
        this.sources = arrayList;
        if (arrayList.isEmpty()) {
            Iterable stringArrayListExtra2 = getIntent().getStringArrayListExtra(EXTRA_LOCAL_PATHS);
            if (stringArrayListExtra2 == null) {
                stringArrayListExtra2 = C1173v.m();
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : stringArrayListExtra2) {
                String str2 = (String) obj2;
                kotlin.jvm.internal.p.f(str2);
                if (!H.x0(str2) && new File(str2).exists()) {
                    arrayList2.add(obj2);
                }
            }
            this.sources = arrayList2;
        }
        int iN = C5685n.n(getIntent().getIntExtra(EXTRA_START_POSITION, 0), 0, C5685n.f(this.sources.size() - 1, 0));
        if (this.sources.isEmpty()) {
            finish();
            return;
        }
        u uVar = new u(this, this.sources, iN, null, getIntent().getBooleanExtra(EXTRA_SHOW_TITLE_BAR, false), false, 40, null);
        this.previewHelper = uVar;
        uVar.W(new InterfaceC5063a() { // from class: com.stepos.agentframework.util.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentImagePreviewActivity.s(this.f23331a);
            }
        });
        setContentView(uVar.I());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        u uVar = this.previewHelper;
        if (uVar != null) {
            uVar.T();
        }
        this.previewHelper = null;
        super.onDestroy();
    }
}
