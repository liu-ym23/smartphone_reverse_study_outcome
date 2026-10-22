package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.graphics.Bitmap;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveParamsListener {

    public static class Stub implements ILiveParamsListener {
        public Stub() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int addComposerNodes(String[] r100) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int addComposerNodesWithExtra(String[] r100, String[] r101) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int animateImageToPreview(String r100, String r101) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void changeBottomIconShowing(boolean r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void changeTouchStickerState(boolean r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void enableMock(boolean r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public boolean getRoomReady() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public ILivePreviewTouchEventDelegate getTouchEventDelegate() {
            return null;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public boolean isLiveTabShowing() {
            return false;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onCloseButtonClick() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onCloseButtonClickWithData(Map<String, String> r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onReverseCamera(int r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onReverseMirror() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onShowBackground(boolean r100, String r101, int r102, boolean r103) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onStickerCancel(Sticker r100, String r101) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onStickerChosen(Sticker r100, String r101) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void onViewCreated() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void pushVideoFrame(int r100, int r101, int r102, long r103) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void registerCameraDetectListener() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int removeComposerNodes(String[] r100) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int replaceComposerNode(String[] r100, int r101, String[] r102, int r103, String[] r104) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void restartLiveFragment() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void sendEffectMsg(int r100, int r101, int r102, String r103) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int setComposerMode(int r100, int r101) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int setComposerNodes(String[] r100) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int setComposerNodesWithExtra(String[] r100, String[] r101) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int setComposerResourcePath(String r100) {
            return 0;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void setMockBitmap(Bitmap r100, int r101, int r102, boolean r103) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public void showBottomTab(boolean r100) {
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveParamsListener
        public int updateComposerNode(String r100, String r101, float r102) {
            return 0;
        }
    }

    int addComposerNodes(String[] r100);

    int addComposerNodesWithExtra(String[] r100, String[] r101);

    int animateImageToPreview(String r100, String r101);

    void changeBottomIconShowing(boolean r100);

    void changeTouchStickerState(boolean r100);

    void enableMock(boolean r100);

    boolean getRoomReady();

    ILivePreviewTouchEventDelegate getTouchEventDelegate();

    boolean isLiveTabShowing();

    void onCloseButtonClick();

    void onCloseButtonClickWithData(Map<String, String> r100);

    void onReverseCamera(int r100);

    void onReverseMirror();

    void onShowBackground(boolean r100, String r101, int r102, boolean r103);

    void onStickerCancel(Sticker r100, String r101);

    void onStickerChosen(Sticker r100, String r101);

    void onViewCreated();

    void pushVideoFrame(int r100, int r101, int r102, long r103);

    void registerCameraDetectListener();

    int removeComposerNodes(String[] r100);

    int replaceComposerNode(String[] r100, int r101, String[] r102, int r103, String[] r104);

    void restartLiveFragment();

    void sendEffectMsg(int r100, int r101, int r102, String r103);

    int setComposerMode(int r100, int r101);

    int setComposerNodes(String[] r100);

    int setComposerNodesWithExtra(String[] r100, String[] r101);

    int setComposerResourcePath(String r100);

    void setMockBitmap(Bitmap r100, int r101, int r102, boolean r103);

    void showBottomTab(boolean r100);

    int updateComposerNode(String r100, String r101, float r102);
}
