package com.zyql.ai.selector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.tools.DoubleUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class PictureSelector {
    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mFragment;

    private PictureSelector(Activity activity) {
        this(activity, null);
    }

    public static PictureSelector create(Activity activity) {
        return new PictureSelector(activity);
    }

    public static List<LocalMedia> obtainMultipleResult(Intent intent) {
        ArrayList parcelableArrayListExtra;
        return (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION)) == null) ? new ArrayList() : parcelableArrayListExtra;
    }

    public static List<LocalMedia> obtainSelectorList(Bundle bundle) {
        if (bundle != null) {
            return bundle.getParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST);
        }
        return null;
    }

    public static Intent putIntentResult(List<LocalMedia> list) {
        return new Intent().putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) list);
    }

    public static void saveSelectorList(Bundle bundle, List<LocalMedia> list) {
        bundle.putParcelableArrayList(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) list);
    }

    public void externalPictureAudio(String str) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PicturePlayAudioActivity.class);
        intent.putExtra(PictureConfig.EXTRA_AUDIO_PATH, str);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.picture_anim_enter, 0);
    }

    public void externalPicturePreview(int i10, List<LocalMedia> list, int i11) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PictureExternalPreviewActivity.class);
        intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
        intent.putExtra("position", i10);
        getActivity().startActivity(intent);
        Activity activity = getActivity();
        if (i11 == 0) {
            i11 = R.anim.picture_anim_enter;
        }
        activity.overridePendingTransition(i11, R.anim.picture_anim_fade_in);
    }

    public void externalPictureVideo(String str) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(getActivity(), (Class<?>) PictureVideoPlayActivity.class);
        intent.putExtra(PictureConfig.EXTRA_VIDEO_PATH, str);
        intent.putExtra(PictureConfig.EXTRA_PREVIEW_VIDEO, true);
        getActivity().startActivity(intent);
    }

    public Activity getActivity() {
        return this.mActivity.get();
    }

    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.mFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public PictureSelectionModel openCamera(int i10) {
        return new PictureSelectionModel(this, i10, true);
    }

    public PictureSelectionModel openGallery(int i10) {
        return new PictureSelectionModel(this, i10);
    }

    public PictureSelectionModel setPictureStyle(PictureParameterStyle pictureParameterStyle) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).setPictureStyle(pictureParameterStyle);
    }

    public PictureSelectionModel themeStyle(int i10) {
        return new PictureSelectionModel(this, PictureMimeType.ofImage()).theme(i10);
    }

    private PictureSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static PictureSelector create(Fragment fragment) {
        return new PictureSelector(fragment);
    }

    private PictureSelector(Activity activity, Fragment fragment) {
        this.mActivity = new WeakReference<>(activity);
        this.mFragment = new WeakReference<>(fragment);
    }

    public void externalPicturePreview(int i10, String str, List<LocalMedia> list, int i11) {
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), (Class<?>) PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST, (ArrayList) list);
            intent.putExtra("position", i10);
            intent.putExtra(PictureConfig.EXTRA_DIRECTORY_PATH, str);
            getActivity().startActivity(intent);
            Activity activity = getActivity();
            if (i11 == 0) {
                i11 = R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i11, R.anim.picture_anim_fade_in);
            return;
        }
        throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
    }
}
