package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/NewPanelAudienceResolutionPickerDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "ResolutionItemView", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewPanelAudienceResolutionPickerDialog extends CommonStandardBottomDialog {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.NewPanelAudienceResolutionPickerDialog$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class ResolutionItemView extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f112430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<String, Unit> f112431b;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.NewPanelAudienceResolutionPickerDialog$ResolutionItemView$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String r100) {
                invoke2(r100);
                return Unit.INSTANCE;
            }
        }

        public final TextView a() {
            return (TextView) this.f112430a.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ResolutionItemView(final Context r100, Function1<? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "selectedCallback");
            super(r100);
            this.f112431b = r101;
            this.f112430a = LazyKt.lazy(new NewPanelAudienceResolutionPickerDialog$ResolutionItemView$tv$2(r100));
            ViewGroup.MarginLayoutParams r102 = new ViewGroup.MarginLayoutParams(-1, (int) fm3.e.a(r100, 32.0f));
            r102.bottomMargin = (int) fm3.e.a(r100, 15.0f);
            r102.leftMargin = (int) fm3.e.a(r100, 4.0f);
            r102.rightMargin = (int) fm3.e.a(r100, 4.0f);
            Unit r103 = Unit.INSTANCE;
            setLayoutParams(r102);
            addView(a());
        }
    }

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolutionItemView f112432a;

        public a(ResolutionItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "resolutionView");
            super(r100);
            this.f112432a = r100;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_audience_video_resolution_picker;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((RecyclerView) findViewById(R.id.mAudienceResolutionPickerRv)).setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        ((RecyclerView) findViewById(R.id.mAudienceResolutionPickerRv)).setAdapter(new NewPanelAudienceResolutionPickerDialog$createAdapter$1(this));
    }
}
