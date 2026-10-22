package com.stepos.ailauncher.task.detail;

import Z8.C1173v;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$id;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$style;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/task/detail/w;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "", "getTheme", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", UxipConstants.f30640D, "onDestroyView", "x", "", "label", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)I", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/task/detail/x;", "onFormatSelected", "Lp9/l;", "getOnFormatSelected", "()Lp9/l;", ExifInterface.LONGITUDE_EAST, "(Lp9/l;)V", "Lr6/d;", "_binding", "Lr6/d;", "", "options", "Ljava/util/List;", "selectedIndex", "I", "z", "()Lr6/d;", "binding", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.detail.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3565w extends com.google.android.material.bottomsheet.b {
    private static final float CHIP_GAP_DP = 8.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float SHEET_CORNER_DP = 32.0f;
    private r6.d _binding;
    private InterfaceC5074l<? super DownloadOption, Y8.t> onFormatSelected;
    private List<DownloadOption> options = C1173v.m();
    private int selectedIndex;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/task/detail/w$a;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/task/detail/x;", "options", "Lcom/stepos/ailauncher/task/detail/w;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Lcom/stepos/ailauncher/task/detail/w;", "", "SHEET_CORNER_DP", "F", "CHIP_GAP_DP", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.detail.w$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C3565w a(List<DownloadOption> options) {
            kotlin.jvm.internal.p.i(options, "options");
            C3565w c3565w = new C3565w();
            c3565w.options = options;
            return c3565w;
        }

        public Companion() {
        }
    }

    public static final float B(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        return SHEET_CORNER_DP;
    }

    public static final void C(C3565w c3565w, View view) {
        c3565w.dismiss();
    }

    public static final void D(C3565w c3565w, View view) {
        DownloadOption downloadOption = (DownloadOption) Z8.F.t0(c3565w.options, c3565w.selectedIndex);
        if (downloadOption == null) {
            return;
        }
        InterfaceC5074l<? super DownloadOption, Y8.t> interfaceC5074l = c3565w.onFormatSelected;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(downloadOption);
        }
        c3565w.dismiss();
    }

    public static final void y(C3565w c3565w, int i10, LinearLayout linearLayout, View view, View view2) {
        int i11 = c3565w.selectedIndex;
        if (i11 == i10) {
            return;
        }
        View childAt = linearLayout.getChildAt(i11);
        if (childAt != null) {
            childAt.setSelected(false);
        }
        c3565w.selectedIndex = i10;
        view.setSelected(true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        if (r0.equals("MARKDOWN") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r0.equals("XLSX") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        if (r0.equals("PPTX") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r0.equals(com.fasterxml.jackson.core.JsonFactory.FORMAT_NAME_JSON) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (r0.equals("HTML") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        if (r0.equals("DOCX") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
    
        if (r0.equals("XLS") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        return com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_xls;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
    
        if (r0.equals("PPT") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
    
        return com.stepos.ailauncher.task.R$drawable.ic_download_format_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        if (r0.equals("HTM") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
    
        if (r0.equals("DOC") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
    
        return com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a8, code lost:
    
        if (r0.equals("CSS") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b1, code lost:
    
        if (r0.equals("MD") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b6, code lost:
    
        return com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_md;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bd, code lost:
    
        if (r0.equals("JS") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c4, code lost:
    
        return com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_code;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A(java.lang.String r1) {
        /*
            r0 = this;
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r1.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case 2377: goto Lb7;
                case 2455: goto Lab;
                case 67043: goto La2;
                case 67864: goto L96;
                case 71873: goto L8d;
                case 79058: goto L81;
                case 79444: goto L75;
                case 83536: goto L69;
                case 87007: goto L5d;
                case 2103872: goto L54;
                case 2228139: goto L4a;
                case 2286824: goto L40;
                case 2462852: goto L36;
                case 2697305: goto L2c;
                case 1029565679: goto L22;
                case 2079330414: goto L15;
                default: goto L13;
            }
        L13:
            goto Lbf
        L15:
            java.lang.String r1 = "FOLDER"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1f
            goto Lbf
        L1f:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_folder
            return r0
        L22:
            java.lang.String r1 = "MARKDOWN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb4
            goto Lbf
        L2c:
            java.lang.String r1 = "XLSX"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto Lbf
        L36:
            java.lang.String r1 = "PPTX"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7e
            goto Lbf
        L40:
            java.lang.String r1 = "JSON"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc2
            goto Lbf
        L4a:
            java.lang.String r1 = "HTML"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc2
            goto Lbf
        L54:
            java.lang.String r1 = "DOCX"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9f
            goto Lbf
        L5d:
            java.lang.String r1 = "XLS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L66
            goto Lbf
        L66:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_xls
            return r0
        L69:
            java.lang.String r1 = "TXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L72
            goto Lbf
        L72:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_txt
            return r0
        L75:
            java.lang.String r1 = "PPT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7e
            goto Lbf
        L7e:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_download_format_ppt
            return r0
        L81:
            java.lang.String r1 = "PDF"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L8a
            goto Lbf
        L8a:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_download_format_pdf
            return r0
        L8d:
            java.lang.String r1 = "HTM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc2
            goto Lbf
        L96:
            java.lang.String r1 = "DOC"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9f
            goto Lbf
        L9f:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_doc
            return r0
        La2:
            java.lang.String r1 = "CSS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc2
            goto Lbf
        Lab:
            java.lang.String r1 = "MD"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb4
            goto Lbf
        Lb4:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_md
            return r0
        Lb7:
            java.lang.String r1 = "JS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc2
        Lbf:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_doc
            return r0
        Lc2:
            int r0 = com.stepos.ailauncher.task.R$drawable.ic_home_space_artifact_code
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.C3565w.A(java.lang.String):int");
    }

    public final void E(InterfaceC5074l<? super DownloadOption, Y8.t> interfaceC5074l) {
        this.onFormatSelected = interfaceC5074l;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public int getTheme() {
        return R$style.TaskDownloadFormatSheetTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        this._binding = r6.d.c(inflater, container, false);
        FrameLayout frameLayoutB = z().b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        return frameLayoutB;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(2);
        window.setDimAmount(0.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        View viewFindViewById;
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        if (dialog != null && (viewFindViewById = dialog.findViewById(R$id.design_bottom_sheet)) != null) {
            viewFindViewById.setBackgroundColor(0);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setNavigationBarColor(0);
            window.setNavigationBarContrastEnforced(false);
            window.clearFlags(2);
            window.setDimAmount(0.0f);
            new androidx.core.view.b0(window, window.getDecorView()).d(false);
        }
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        LinearLayout sheetPanel = z().sheetPanel;
        kotlin.jvm.internal.p.h(sheetPanel, "sheetPanel");
        hVar.j(sheetPanel, SHEET_CORNER_DP);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, true);
        LinearLayout sheetPanel2 = z().sheetPanel;
        kotlin.jvm.internal.p.h(sheetPanel2, "sheetPanel");
        C2773b6 c2773b6H = C2773b6.h(c2773b6, sheetPanel2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.detail.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Float.valueOf(C3565w.B((View) obj));
            }
        }, y7.o.INSTANCE.h(), false, 8, null);
        ImageView ivClose = z().ivClose;
        kotlin.jvm.internal.p.h(ivClose, "ivClose");
        C2773b6.p(c2773b6H, new View[]{ivClose}, null, false, 2, null);
        z().ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C3565w.C(this.f28743a, view2);
            }
        });
        x();
        z().btnDownload.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C3565w.D(this.f28747a, view2);
            }
        });
    }

    public final void x() {
        final LinearLayout formatContainer = z().formatContainer;
        kotlin.jvm.internal.p.h(formatContainer, "formatContainer");
        formatContainer.removeAllViews();
        int i10 = (int) ((getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        final int i11 = 0;
        for (Object obj : this.options) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            DownloadOption downloadOption = (DownloadOption) obj;
            final View viewInflate = LayoutInflater.from(requireContext()).inflate(R$layout.item_download_format, (ViewGroup) formatContainer, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            if (i11 > 0) {
                layoutParams.setMarginStart(i10);
            }
            viewInflate.setLayoutParams(layoutParams);
            ((ImageView) viewInflate.findViewById(com.stepos.ailauncher.task.R$id.ivFormatIcon)).setImageResource(A(downloadOption.getLabel()));
            ((TextView) viewInflate.findViewById(com.stepos.ailauncher.task.R$id.tvFormatLabel)).setText(downloadOption.getLabel());
            viewInflate.setSelected(i11 == this.selectedIndex);
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.detail.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3565w.y(this.f28749a, i11, formatContainer, viewInflate, view);
                }
            });
            formatContainer.addView(viewInflate);
            i11 = i12;
        }
    }

    public final r6.d z() {
        r6.d dVar = this._binding;
        kotlin.jvm.internal.p.f(dVar);
        return dVar;
    }
}
