package com.zyql.ai.selector.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.K;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.listener.OnItemClickListener;
import com.zyql.ai.selector.tools.ScreenUtils;

/* loaded from: classes4.dex */
public class PhotoItemSelectedDialog extends DialogInterfaceOnCancelListenerC1374l implements View.OnClickListener {
    public static final int IMAGE_CAMERA = 0;
    public static final int VIDEO_CAMERA = 1;
    private OnItemClickListener onItemClickListener;
    private TextView tvPictureCancel;
    private TextView tvPicturePhoto;
    private TextView tvPictureVideo;

    private void initDialogStyle() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(ScreenUtils.getScreenWidth(getContext()), -2);
        window.setGravity(80);
        window.setWindowAnimations(R.style.PictureThemeDialogFragmentAnim);
    }

    public static PhotoItemSelectedDialog newInstance() {
        return new PhotoItemSelectedDialog();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            if (id == R.id.picture_tv_photo) {
                onItemClickListener.onItemClick(view, 0);
            }
            if (id == R.id.picture_tv_video) {
                this.onItemClickListener.onItemClick(view, 1);
            }
        }
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
        }
        return layoutInflater.inflate(R.layout.picture_dialog_camera_selected, viewGroup);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initDialogStyle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tvPicturePhoto = (TextView) view.findViewById(R.id.picture_tv_photo);
        this.tvPictureVideo = (TextView) view.findViewById(R.id.picture_tv_video);
        this.tvPictureCancel = (TextView) view.findViewById(R.id.picture_tv_cancel);
        this.tvPictureVideo.setOnClickListener(this);
        this.tvPicturePhoto.setOnClickListener(this);
        this.tvPictureCancel.setOnClickListener(this);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public void show(FragmentManager fragmentManager, String str) {
        K kQ = fragmentManager.q();
        kQ.d(this, str);
        kQ.h();
    }
}
