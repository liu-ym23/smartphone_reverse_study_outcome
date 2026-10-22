package com.stepos.ailauncher.chat.fragment;

import Ua.C1060i;
import Z8.C1172u;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.C1398p;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.C2505k;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.ProgressSplitTextView;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail;
import com.stepos.ailauncher.foundation.appstore.j;
import io.ktor.http.LinkHeader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.G;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\b\r*\u0002@G\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020(H\u0002¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020(H\u0002¢\u0006\u0004\b/\u0010+J!\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010\u0003J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u001eH\u0016¢\u0006\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010\u001dR\u0016\u0010F\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010\u001dR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010 R\u0014\u0010P\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010 ¨\u0006S"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "", "position", "LY8/t;", "i0", "(Landroid/view/View;Ljava/util/List;I)V", "e0", "Y", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;", Const.INTENT_KEY_UMID, ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;)V", "Landroid/widget/TextView;", "descView", "description", "R", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Ll5/c;", "binding", "Q", "(Ll5/c;Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;)V", "Z", "", "X", "()Z", "progress", "f0", "(I)V", "btn", "pct", "h0", "(Landroid/view/View;I)V", "", SingleFileBundle.KEY_BYTES, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)Ljava/lang/String;", "count", ExifInterface.GPS_DIRECTION_TRUE, "timeMs", "U", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "hidden", "onHiddenChanged", "(Z)V", "Lcom/stepos/ailauncher/chat/adapter/k;", "screenshotAdapter", "Lcom/stepos/ailauncher/chat/adapter/k;", "Lcom/stepos/agentframework/util/u;", "screenshotPreview", "Lcom/stepos/agentframework/util/u;", "com/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$c", "screenshotBackCallback", "Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$c;", "detail", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionDetail;", "installing", "updating", "com/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$b", "installCallback", "Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$b;", ExifInterface.LONGITUDE_WEST, "()Ljava/lang/String;", "pkg", "e", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooAppDetailFragment extends com.stepos.ailauncher.sheet.nav.a {
    private static final String ARG_APP_ID = "app_id";
    private static final String ARG_ICON_URL = "icon_url";
    private static final String ARG_NAME = "name";
    private static final String ARG_PACKAGE_NAME = "package_name";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESC_COLLAPSED_LINES = 3;
    private AppVersionDetail detail;
    private final b installCallback;
    private boolean installing;
    private final C2505k screenshotAdapter;
    private final c screenshotBackCallback;
    private com.stepos.agentframework.util.u screenshotPreview;
    private boolean updating;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$a;", "", "<init>", "()V", "", "appId", "", "packageName", "name", "iconUrl", "Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment;", Const.INTENT_KEY_APIKEY, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/chat/fragment/AmooAppDetailFragment;", "ARG_APP_ID", "Ljava/lang/String;", "ARG_PACKAGE_NAME", "ARG_NAME", "ARG_ICON_URL", "", "DESC_COLLAPSED_LINES", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooAppDetailFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooAppDetailFragment a(long appId, String packageName, String name, String iconUrl) {
            AmooAppDetailFragment amooAppDetailFragment = new AmooAppDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(AmooAppDetailFragment.ARG_APP_ID, appId);
            bundle.putString(AmooAppDetailFragment.ARG_PACKAGE_NAME, packageName);
            bundle.putString("name", name);
            bundle.putString(AmooAppDetailFragment.ARG_ICON_URL, iconUrl);
            amooAppDetailFragment.setArguments(bundle);
            return amooAppDetailFragment;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$b", "Lcom/stepos/ailauncher/foundation/appstore/j$a;", "", "pkg", "", "progress", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;I)V", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements j.a {
        public b() {
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void a(String pkg, int progress) throws PackageManager.NameNotFoundException {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            if (kotlin.jvm.internal.p.d(pkg, AmooAppDetailFragment.this.W())) {
                AmooAppDetailFragment.this.installing = true;
                AmooAppDetailFragment.this.f0(progress);
            }
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void b(String pkg) throws PackageManager.NameNotFoundException {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            if (kotlin.jvm.internal.p.d(pkg, AmooAppDetailFragment.this.W())) {
                AmooAppDetailFragment.this.installing = false;
                AmooAppDetailFragment.this.updating = false;
                AmooAppDetailFragment.g0(AmooAppDetailFragment.this, 0, 1, null);
            }
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.a
        public void c(String pkg) throws PackageManager.NameNotFoundException {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            if (kotlin.jvm.internal.p.d(pkg, AmooAppDetailFragment.this.W())) {
                AmooAppDetailFragment.this.installing = false;
                AmooAppDetailFragment.this.updating = false;
                AmooAppDetailFragment.g0(AmooAppDetailFragment.this, 0, 1, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooAppDetailFragment$c", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC1417G {
        public c() {
            super(false);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            com.stepos.agentframework.util.u uVar = AmooAppDetailFragment.this.screenshotPreview;
            if (uVar != null && uVar.O()) {
                com.stepos.agentframework.util.u.INSTANCE.d();
            } else {
                setEnabled(false);
                AmooAppDetailFragment.this.requireActivity().getOnBackPressedDispatcher().q();
            }
        }
    }

    public AmooAppDetailFragment() {
        super(R$layout.fragment_amoo_app_detail);
        this.screenshotAdapter = new C2505k(new AmooAppDetailFragment$screenshotAdapter$1(this));
        this.screenshotBackCallback = new c();
        this.installCallback = new b();
    }

    private final void Y() {
        Bundle arguments = getArguments();
        long j10 = arguments != null ? arguments.getLong(ARG_APP_ID) : 0L;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C1060i.d(C1398p.a(viewLifecycleOwner), null, null, new AmooAppDetailFragment$loadDetail$1(j10, this, null), 3, null);
    }

    public static final Y8.t a0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final Y8.t b0(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        attachGradientBlur.n(64.0f);
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void c0(AmooAppDetailFragment amooAppDetailFragment, View view) {
        if (amooAppDetailFragment.x()) {
            return;
        }
        amooAppDetailFragment.o();
    }

    public static final void d0(AmooAppDetailFragment amooAppDetailFragment, View view) throws PackageManager.NameNotFoundException {
        amooAppDetailFragment.Z();
    }

    public static /* synthetic */ void g0(AmooAppDetailFragment amooAppDetailFragment, int i10, int i11, Object obj) throws PackageManager.NameNotFoundException {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        amooAppDetailFragment.f0(i10);
    }

    public static final Y8.t j0(com.stepos.agentframework.util.u uVar, AmooAppDetailFragment amooAppDetailFragment) {
        uVar.D();
        if (amooAppDetailFragment.screenshotPreview == uVar) {
            amooAppDetailFragment.screenshotPreview = null;
            amooAppDetailFragment.screenshotBackCallback.setEnabled(false);
        }
        return Y8.t.f7040a;
    }

    public final void Q(l5.c binding, AppVersionDetail d10) {
        binding.cardAssetInfo.setVisibility(0);
        TextView textView = binding.tvInfoVersion;
        String versionName = d10.getVersionName();
        if (versionName == null) {
            versionName = O6.l.DATE_SEPARATOR;
        }
        textView.setText(versionName);
        LinearLayout linearLayout = binding.rowInfoCategory;
        String categoryName = d10.getCategoryName();
        linearLayout.setVisibility((categoryName == null || categoryName.length() == 0) ? 8 : 0);
        TextView textView2 = binding.tvInfoCategory;
        String categoryName2 = d10.getCategoryName();
        if (categoryName2 == null) {
            categoryName2 = "";
        }
        textView2.setText(categoryName2);
        binding.tvInfoUpdated.setText(U(d10.getVersionTime()));
        binding.tvInfoDownloads.setText(T(d10.getDownloadCount()));
    }

    public final void R(TextView descView, String description) {
        if (description == null || description.length() == 0) {
            descView.setVisibility(8);
            return;
        }
        descView.setVisibility(0);
        com.stepos.ailauncher.common.widget.b bVar = com.stepos.ailauncher.common.widget.b.INSTANCE;
        String string = getString(R$string.amoo_app_detail_expand);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        String string2 = getString(R$string.amoo_app_detail_collapse);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        bVar.b(descView, description, 3, string, string2, -1, com.stepos.ailauncher.chat.view.F.INSTANCE.a(description));
    }

    public final void S(AppVersionDetail d10) throws PackageManager.NameNotFoundException {
        View view = getView();
        if (view == null) {
            return;
        }
        l5.c cVarA = l5.c.a(view);
        kotlin.jvm.internal.p.h(cVarA, "bind(...)");
        com.stepos.ailauncher.chat.trace.a aVar = com.stepos.ailauncher.chat.trace.a.INSTANCE;
        Long lValueOf = Long.valueOf(d10.getId());
        String name = d10.getName();
        if (name == null) {
            Bundle arguments = getArguments();
            name = arguments != null ? arguments.getString("name") : null;
        }
        aVar.c(lValueOf, name, d10.getVersionName(), X() ? "installed" : com.stepos.ailauncher.chat.trace.a.INSTALL_UNINSTALLED);
        TextView textView = cVarA.tvAppName;
        String name2 = d10.getName();
        if (name2 == null) {
            name2 = "";
        }
        textView.setText(name2);
        ImageView ivAppIcon = cVarA.ivAppIcon;
        kotlin.jvm.internal.p.h(ivAppIcon, "ivAppIcon");
        C2765a9.b(ivAppIcon, d10.getIconUrl(), R$drawable.ic_amoo_market_agent, false);
        TextView textView2 = cVarA.tvAppSubtitle;
        List listC = C1172u.c();
        String versionName = d10.getVersionName();
        if (versionName != null) {
            listC.add(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + versionName);
        }
        String publisher = d10.getPublisher();
        if (publisher != null) {
            listC.add(publisher);
        }
        if (d10.getVerified()) {
            String string = getString(R$string.amoo_app_detail_verified);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            listC.add(string);
        }
        textView2.setText(Z8.F.A0(C1172u.a(listC), " · ", null, null, 0, null, null, 62, null));
        TextView tvAppDesc = cVarA.tvAppDesc;
        kotlin.jvm.internal.p.h(tvAppDesc, "tvAppDesc");
        R(tvAppDesc, d10.getDescription());
        cVarA.tvStatSizeValue.setText(V(d10.getSize()));
        cVarA.tvStatDownloadsValue.setText(T(d10.getDownloadCount()));
        cVarA.tvStatUpdatedValue.setText(U(d10.getVersionTime()));
        this.screenshotAdapter.g(d10.getImageUrls());
        cVarA.rvAppScreenshots.setVisibility(d10.getImageUrls().isEmpty() ? 8 : 0);
        Q(cVarA, d10);
        g0(this, 0, 1, null);
    }

    public final String T(long count) {
        if (count < 1000) {
            return count <= 0 ? "少于1000" : String.valueOf(count);
        }
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
        String str = String.format(Locale.US, "%.1fK", Arrays.copyOf(new Object[]{Double.valueOf(count / 1000.0d)}, 1));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final String U(long timeMs) {
        if (timeMs <= 0) {
            return O6.l.DATE_SEPARATOR;
        }
        String str = new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(new Date(timeMs));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final String V(long bytes) {
        if (bytes <= 0) {
            return O6.l.DATE_SEPARATOR;
        }
        double d10 = bytes / 1024.0d;
        double d11 = d10 / 1024.0d;
        if (d11 >= 1.0d) {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            String str = String.format(Locale.US, "%.1fMB", Arrays.copyOf(new Object[]{Double.valueOf(d11)}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            return str;
        }
        kotlin.jvm.internal.y yVar2 = kotlin.jvm.internal.y.f34840a;
        String str2 = String.format(Locale.US, "%.0fKB", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        return str2;
    }

    public final String W() {
        String packageName;
        AppVersionDetail appVersionDetail = this.detail;
        if (appVersionDetail != null && (packageName = appVersionDetail.getPackageName()) != null) {
            return packageName;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString(ARG_PACKAGE_NAME);
        }
        return null;
    }

    public final boolean X() {
        String strW;
        Context context = getContext();
        if (context == null || (strW = W()) == null) {
            return false;
        }
        return com.stepos.ailauncher.foundation.appstore.j.INSTANCE.v(context, strW);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z() throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r9 = this;
            android.content.Context r0 = r9.getContext()
            if (r0 != 0) goto L8
            goto L82
        L8:
            java.lang.String r1 = r9.W()
            if (r1 != 0) goto L10
            goto L82
        L10:
            boolean r2 = r9.installing
            if (r2 == 0) goto L16
            goto L82
        L16:
            com.stepos.ailauncher.foundation.appstore.j r2 = com.stepos.ailauncher.foundation.appstore.j.INSTANCE
            boolean r3 = r2.v(r0, r1)
            com.stepos.ailauncher.chat.fragment.a r4 = com.stepos.ailauncher.chat.fragment.C2579a.INSTANCE
            com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail r5 = r9.detail
            r6 = 0
            if (r5 == 0) goto L28
            java.lang.String r5 = r5.getVersionName()
            goto L29
        L28:
            r5 = r6
        L29:
            java.lang.String r7 = r2.u(r0, r1)
            boolean r4 = r4.c(r3, r5, r7)
            com.stepos.ailauncher.chat.trace.a r5 = com.stepos.ailauncher.chat.trace.a.INSTANCE
            com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail r7 = r9.detail
            if (r7 == 0) goto L40
            long r7 = r7.getId()
        L3b:
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            goto L4e
        L40:
            android.os.Bundle r7 = r9.getArguments()
            if (r7 == 0) goto L4d
            java.lang.String r8 = "app_id"
            long r7 = r7.getLong(r8)
            goto L3b
        L4d:
            r7 = r6
        L4e:
            if (r4 == 0) goto L54
            java.lang.String r8 = "update"
            goto L5c
        L54:
            if (r3 == 0) goto L5a
            java.lang.String r8 = "open"
            goto L5c
        L5a:
            java.lang.String r8 = "download"
        L5c:
            r5.a(r7, r8)
            if (r3 == 0) goto L83
            if (r4 != 0) goto L83
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r0 = r0.getLaunchIntentForPackage(r1)
            if (r0 == 0) goto L82
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L78
            r9.startActivity(r0)     // Catch: java.lang.Throwable -> L78
            Y8.t r9 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L78
            kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L78
            return
        L78:
            r9 = move-exception
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.C4849c.a(r9)
            kotlin.Result.b(r9)
        L82:
            return
        L83:
            r9.updating = r4
            r3 = 1
            r9.installing = r3
            r5 = 0
            g0(r9, r5, r3, r6)
            r5 = 0
            if (r4 == 0) goto L98
            com.stepos.ailauncher.foundation.appstore.api.AppVersionDetail r9 = r9.detail
            if (r9 == 0) goto L98
            long r5 = r9.getId()
        L98:
            r2.H(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.fragment.AmooAppDetailFragment.Z():void");
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    public final void e0() {
        com.stepos.agentframework.util.u uVar = this.screenshotPreview;
        if (uVar != null) {
            uVar.D();
        }
        this.screenshotPreview = null;
        this.screenshotBackCallback.setEnabled(false);
    }

    public final void f0(int progress) throws PackageManager.NameNotFoundException {
        Context context;
        View view = getView();
        if (view == null || (context = getContext()) == null) {
            return;
        }
        ProgressSplitTextView btnInstall = l5.c.a(view).btnInstall;
        kotlin.jvm.internal.p.h(btnInstall, "btnInstall");
        String strW = W();
        if (strW == null || strW.length() == 0) {
            btnInstall.setText(getString(R$string.amoo_app_detail_install_app));
            btnInstall.setEnabled(false);
            btnInstall.setBackgroundResource(R$drawable.bg_amoo_app_detail_install_button);
            btnInstall.setProgressFraction(1.0f);
            return;
        }
        if (this.installing) {
            btnInstall.setText(getString(this.updating ? R$string.amoo_app_detail_updating : R$string.amoo_app_detail_installing, Integer.valueOf(progress)));
            btnInstall.setEnabled(false);
            btnInstall.setBackgroundResource(R$drawable.bg_amoo_app_installing_progress);
            h0(btnInstall, progress);
            btnInstall.setProgressFraction(progress / 100.0f);
            return;
        }
        com.stepos.ailauncher.foundation.appstore.j jVar = com.stepos.ailauncher.foundation.appstore.j.INSTANCE;
        boolean zV = jVar.v(context, strW);
        C2579a c2579a = C2579a.INSTANCE;
        AppVersionDetail appVersionDetail = this.detail;
        btnInstall.setText(getString(c2579a.c(zV, appVersionDetail != null ? appVersionDetail.getVersionName() : null, jVar.u(context, strW)) ? R$string.amoo_app_detail_upgrade : zV ? R$string.amoo_app_detail_open : R$string.amoo_app_detail_install_app));
        btnInstall.setEnabled(true);
        btnInstall.setBackgroundResource(R$drawable.bg_amoo_app_detail_install_button);
        btnInstall.setProgressFraction(1.0f);
    }

    public final void h0(View btn, int pct) {
        Drawable drawableFindDrawableByLayerId;
        Drawable background = btn.getBackground();
        LayerDrawable layerDrawable = background instanceof LayerDrawable ? (LayerDrawable) background : null;
        if (layerDrawable == null || (drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R$id.app_install_progress_fill)) == null) {
            return;
        }
        drawableFindDrawableByLayerId.setLevel(C5685n.n(pct * 100, 0, 10000));
    }

    public final void i0(View anchor, List<String> sources, int position) {
        if (!anchor.isAttachedToWindow() || position < 0 || position >= sources.size()) {
            return;
        }
        View rootView = anchor.getRootView();
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup == null) {
            return;
        }
        e0();
        Context context = anchor.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        final com.stepos.agentframework.util.u uVar = new com.stepos.agentframework.util.u(context, sources, position, viewGroup, true, false);
        this.screenshotPreview = uVar;
        uVar.W(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.fragment.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AmooAppDetailFragment.j0(uVar, this);
            }
        });
        uVar.X();
        this.screenshotBackCallback.setEnabled(true);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        e0();
        String strW = W();
        if (strW != null) {
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.F(strW, this.installCallback);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            e0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() throws PackageManager.NameNotFoundException {
        super.onResume();
        g0(this, 0, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        boolean z10 = false;
        kotlin.jvm.internal.i iVar = null;
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        l5.c cVarA = l5.c.a(view);
        kotlin.jvm.internal.p.h(cVarA, "bind(...)");
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.m(viewLifecycleOwner, this.screenshotBackCallback);
        com.stepos.ailauncher.sheet.S sT = t();
        if (sT != null) {
            sT.setSheetDragGestureHandleView(cVarA.detailTopBar);
        }
        ImageView btnBack = cVarA.btnBack;
        kotlin.jvm.internal.p.h(btnBack, "btnBack");
        ProgressSplitTextView btnInstall = cVarA.btnInstall;
        kotlin.jvm.internal.p.h(btnInstall, "btnInstall");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6P = C2773b6.p(new C2773b6(viewLifecycleOwner2, z10, 2, iVar), new View[]{btnBack}, y7.o.INSTANCE.i(), false, 4, null);
        View topChromeBlur = cVarA.topChromeBlur;
        kotlin.jvm.internal.p.h(topChromeBlur, "topChromeBlur");
        C2773b6 c2773b6J = C2773b6.j(c2773b6P, new View[]{topChromeBlur}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAppDetailFragment.a0((A7.B) obj);
            }
        }, 4, null);
        View bottomChromeBlur = cVarA.bottomChromeBlur;
        kotlin.jvm.internal.p.h(bottomChromeBlur, "bottomChromeBlur");
        C2773b6.j(c2773b6J, new View[]{bottomChromeBlur}, null, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooAppDetailFragment.b0((A7.B) obj);
            }
        }, 6, null);
        btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooAppDetailFragment.c0(this.f25315a, view2);
            }
        });
        RecyclerView recyclerView = cVarA.rvAppScreenshots;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.screenshotAdapter);
        btnInstall.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws PackageManager.NameNotFoundException {
                AmooAppDetailFragment.d0(this.f25317a, view2);
            }
        });
        btnInstall.setFilledTextColor(-14935010);
        btnInstall.setUnfilledTextColor(-1);
        TextView textView = cVarA.tvAppName;
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("name") : null;
        if (string == null) {
            string = "";
        }
        textView.setText(string);
        ImageView ivAppIcon = cVarA.ivAppIcon;
        kotlin.jvm.internal.p.h(ivAppIcon, "ivAppIcon");
        Bundle arguments2 = getArguments();
        C2765a9.b(ivAppIcon, arguments2 != null ? arguments2.getString(ARG_ICON_URL) : null, R$drawable.ic_amoo_market_agent, false);
        g0(this, 0, 1, null);
        String strW = W();
        if (strW != null) {
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.n(strW, this.installCallback);
        }
        Y();
    }
}
