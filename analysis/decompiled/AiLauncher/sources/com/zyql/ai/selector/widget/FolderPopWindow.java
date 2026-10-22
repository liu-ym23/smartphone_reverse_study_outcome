package com.zyql.ai.selector.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.adapter.PictureAlbumDirectoryAdapter;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.LocalMediaFolder;
import com.zyql.ai.selector.listener.OnAlbumItemClickListener;
import com.zyql.ai.selector.style.PictureParameterStyle;
import com.zyql.ai.selector.style.PictureSelectorUIStyle;
import com.zyql.ai.selector.tools.AnimUtils;
import com.zyql.ai.selector.tools.AttrsUtils;
import com.zyql.ai.selector.tools.ScreenUtils;
import java.util.List;

/* loaded from: classes4.dex */
public class FolderPopWindow extends PopupWindow {
    private PictureAlbumDirectoryAdapter adapter;
    private int chooseMode;
    private PictureSelectionConfig config;
    private Context context;
    private Drawable drawableDown;
    private Drawable drawableUp;
    private boolean isDismiss = false;
    private ImageView ivArrowView;
    private RecyclerView mRecyclerView;
    private int maxHeight;
    private View rootViewBg;
    private View window;

    public FolderPopWindow(Context context) {
        this.context = context;
        PictureSelectionConfig pictureSelectionConfig = PictureSelectionConfig.getInstance();
        this.config = pictureSelectionConfig;
        this.chooseMode = pictureSelectionConfig.chooseMode;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.picture_window_folder, (ViewGroup) null);
        this.window = viewInflate;
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        PictureSelectorUIStyle pictureSelectorUIStyle = PictureSelectionConfig.uiStyle;
        if (pictureSelectorUIStyle != null) {
            int i10 = pictureSelectorUIStyle.picture_top_titleArrowUpDrawable;
            if (i10 != 0) {
                this.drawableUp = androidx.core.content.a.e(context, i10);
            }
            int i11 = PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable;
            if (i11 != 0) {
                this.drawableDown = androidx.core.content.a.e(context, i11);
            }
        } else {
            PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
            if (pictureParameterStyle != null) {
                int i12 = pictureParameterStyle.pictureTitleUpResId;
                if (i12 != 0) {
                    this.drawableUp = androidx.core.content.a.e(context, i12);
                }
                int i13 = PictureSelectionConfig.style.pictureTitleDownResId;
                if (i13 != 0) {
                    this.drawableDown = androidx.core.content.a.e(context, i13);
                }
            } else {
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                if (pictureSelectionConfig2.isWeChatStyle) {
                    this.drawableUp = androidx.core.content.a.e(context, R.drawable.picture_icon_wechat_up);
                    this.drawableDown = androidx.core.content.a.e(context, R.drawable.picture_icon_wechat_down);
                } else {
                    int i14 = pictureSelectionConfig2.upResId;
                    if (i14 != 0) {
                        this.drawableUp = androidx.core.content.a.e(context, i14);
                    } else {
                        this.drawableUp = AttrsUtils.getTypeValueDrawable(context, R.attr.picture_arrow_up_icon, R.drawable.picture_icon_arrow_up);
                    }
                    int i15 = this.config.downResId;
                    if (i15 != 0) {
                        this.drawableDown = androidx.core.content.a.e(context, i15);
                    } else {
                        this.drawableDown = AttrsUtils.getTypeValueDrawable(context, R.attr.picture_arrow_down_icon, R.drawable.picture_icon_arrow_down);
                    }
                }
            }
        }
        this.maxHeight = (int) (ScreenUtils.getScreenHeight(context) * 0.6d);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
    }

    private /* synthetic */ void lambda$initView$1(View view) {
        dismiss();
    }

    public void bindFolder(List<LocalMediaFolder> list) {
        this.adapter.setChooseMode(this.chooseMode);
        this.adapter.bindFolderData(list);
        this.mRecyclerView.getLayoutParams().height = (list == null || list.size() <= 8) ? -2 : this.maxHeight;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isDismiss) {
            return;
        }
        this.rootViewBg.animate().alpha(0.0f).setDuration(50L).start();
        this.ivArrowView.setImageDrawable(this.drawableDown);
        AnimUtils.rotateArrow(this.ivArrowView, false);
        this.isDismiss = true;
        super.dismiss();
        this.isDismiss = false;
    }

    public LocalMediaFolder getFolder(int i10) {
        if (this.adapter.getFolderData().size() <= 0 || i10 >= this.adapter.getFolderData().size()) {
            return null;
        }
        return this.adapter.getFolderData().get(i10);
    }

    public List<LocalMediaFolder> getFolderData() {
        return this.adapter.getFolderData();
    }

    public void initView() {
        this.rootViewBg = this.window.findViewById(R.id.rootViewBg);
        this.adapter = new PictureAlbumDirectoryAdapter(this.config);
        RecyclerView recyclerView = (RecyclerView) this.window.findViewById(R.id.folder_list);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        this.mRecyclerView.setAdapter(this.adapter);
        this.window.findViewById(R.id.rootView);
        this.rootViewBg.setOnClickListener(new View.OnClickListener() { // from class: com.zyql.ai.selector.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f32010a.lambda$initView$0(view);
            }
        });
    }

    public boolean isEmpty() {
        return this.adapter.getFolderData().size() == 0;
    }

    public void setArrowImageView(ImageView imageView) {
        this.ivArrowView = imageView;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.adapter.setOnAlbumItemClickListener(onAlbumItemClickListener);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        try {
            super.showAsDropDown(view);
            this.isDismiss = false;
            this.ivArrowView.setImageDrawable(this.drawableUp);
            AnimUtils.rotateArrow(this.ivArrowView, true);
            this.rootViewBg.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void updateFolderCheckStatus(List<LocalMedia> list) {
        int i10;
        try {
            List<LocalMediaFolder> folderData = this.adapter.getFolderData();
            int size = folderData.size();
            int size2 = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                LocalMediaFolder localMediaFolder = folderData.get(i11);
                localMediaFolder.setCheckedNum(0);
                for (0; i10 < size2; i10 + 1) {
                    i10 = (localMediaFolder.getName().equals(list.get(i10).getParentFolderName()) || localMediaFolder.getBucketId() == -1) ? 0 : i10 + 1;
                    localMediaFolder.setCheckedNum(1);
                    break;
                }
            }
            this.adapter.bindFolderData(folderData);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
