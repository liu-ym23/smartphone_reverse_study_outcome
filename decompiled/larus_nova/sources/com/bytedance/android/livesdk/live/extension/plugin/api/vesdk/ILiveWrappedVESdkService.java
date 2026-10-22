package com.bytedance.android.livesdk.live.extension.plugin.api.vesdk;

import android.view.SurfaceView;
import com.bytedance.android.live.base.IService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import hg2.c;
import ig2.d;
import ig2.e;
import ig2.f;
import ig2.g;
import ig2.h;
import ig2.i;
import ig2.j;
import ig2.k;
import kotlin.Metadata;
import va1.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 $2\u00020\u0001:\u0001%J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\"H\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/vesdk/ILiveWrappedVESdkService;", "Lcom/bytedance/android/live/base/IService;", "Lhg2/b;", "getVESDK", "Lhg2/a;", "getVEConfigCenter", "Lhg2/c;", "getVEUtils", "Lig2/b;", "newNLEEditor", "Lig2/c;", "newNLEMediaConfig", "mediaConfig", "Landroid/view/SurfaceView;", "surfaceView", "nleEditor", "Lig2/d;", "newNLEMediaSessionPublic", "Lig2/f;", "newNLESegmentColor", "Lig2/k;", "newNLETrackSlot", "Lig2/j;", "newNLETrack", "Lig2/g;", "newNLESegmentComposerFilter", "Lig2/e;", "newNLEResourceNode", "Lig2/h;", "newNLEStringFloatPair", "Lig2/i;", "newNLEStringStringPair", "Lig2/a;", "getNLE", "", "NLEMediaPublic_loadLibrary", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedVESdkService extends IService {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147470a = null;

        public a() {
        }

        static {
            f147470a = new a();
        }

        public static ILiveWrappedVESdkService a() {
            return (ILiveWrappedVESdkService) b.a.f553922a.a(ILiveWrappedVESdkService.class);
        }
    }

    static {
        Companion = a.f147470a;
    }

    void NLEMediaPublic_loadLibrary();

    ig2.a getNLE();

    hg2.a getVEConfigCenter();

    hg2.b getVESDK();

    c getVEUtils();

    ig2.b newNLEEditor();

    ig2.c newNLEMediaConfig();

    d newNLEMediaSessionPublic(ig2.c r100, SurfaceView r101, ig2.b r102);

    e newNLEResourceNode();

    f newNLESegmentColor();

    g newNLESegmentComposerFilter();

    h newNLEStringFloatPair();

    i newNLEStringStringPair();

    j newNLETrack();

    k newNLETrackSlot();
}
