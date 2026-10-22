package android.view.result;

import C7.c;
import android.view.result.PickVisualMediaRequest;
import android.view.result.contract.ActivityResultContracts;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u0007\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001aB\u0010\u0000\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000e"}, d2 = {"PickVisualMediaRequest", "Landroidx/activity/result/PickVisualMediaRequest;", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "maxItems", "", "isOrderedSelection", "", "defaultTab", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "accentColor", "", "mediaCapabilitiesForTranscoding", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$MediaCapabilities;", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PickVisualMediaRequestKt {
    @c
    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
        k.f(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, Object obj) {
        if ((i & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType);
    }

    @c
    public static final /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i) {
        k.f(mediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).build();
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.f(mediaType, "mediaType");
        k.f(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z10).setDefaultTab(defaultTab).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.INSTANCE.getMaxItems$activity_release();
        }
        return PickVisualMediaRequest(visualMediaType, i);
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.INSTANCE.getMaxItems$activity_release();
        }
        if ((i6 & 4) != 0) {
            z10 = false;
        }
        if ((i6 & 8) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(visualMediaType, i, z10, defaultTab);
    }

    public static final PickVisualMediaRequest PickVisualMediaRequest(long j5, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.f(mediaType, "mediaType");
        k.f(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z10).setDefaultTab(defaultTab).setAccentColor(j5).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(long j5, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType2 = visualMediaType;
        if ((i6 & 4) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.INSTANCE.getMaxItems$activity_release();
        }
        int i10 = i;
        if ((i6 & 8) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i6 & 16) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(j5, visualMediaType2, i10, z11, defaultTab);
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if ((i6 & 4) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.INSTANCE.getMaxItems$activity_release();
        }
        if ((i6 & 8) != 0) {
            z10 = false;
        }
        if ((i6 & 16) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(mediaCapabilities, visualMediaType, i, z10, defaultTab);
    }

    @RequiresApi(33)
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.f(mediaType, "mediaType");
        k.f(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z10).setDefaultTab(defaultTab).setMediaCapabilitiesForTranscoding(mediaCapabilities).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, long j5, ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType2 = visualMediaType;
        if ((i6 & 8) != 0) {
            i = ActivityResultContracts.PickMultipleVisualMedia.INSTANCE.getMaxItems$activity_release();
        }
        int i10 = i;
        if ((i6 & 16) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i6 & 32) != 0) {
            defaultTab = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequest(mediaCapabilities, j5, visualMediaType2, i10, z11, defaultTab);
    }

    @RequiresApi(33)
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.MediaCapabilities mediaCapabilities, long j5, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, @IntRange(from = 2) int i, boolean z10, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        k.f(mediaType, "mediaType");
        k.f(defaultTab, "defaultTab");
        return new PickVisualMediaRequest.Builder().setMediaType(mediaType).setMaxItems(i).setOrderedSelection(z10).setDefaultTab(defaultTab).setAccentColor(j5).setMediaCapabilitiesForTranscoding(mediaCapabilities).build();
    }
}
