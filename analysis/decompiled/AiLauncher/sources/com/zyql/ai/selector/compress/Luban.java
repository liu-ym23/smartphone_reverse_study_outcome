package com.zyql.ai.selector.compress;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.thread.PictureThreadUtils;
import com.zyql.ai.selector.tools.AndroidQTransformUtils;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class Luban {
    private static final String TAG = "Luban";
    private final int compressQuality;
    private final int dataCount;
    private final boolean focusAlpha;
    private int index;
    private final boolean isAutoRotating;
    private final boolean isCamera;
    private final OnCompressListener mCompressListener;
    private final CompressionPredicate mCompressionPredicate;
    private final int mLeastCompressSize;
    private final String mNewFileName;
    private final List<String> mPaths;
    private final OnRenameListener mRenameListener;
    private final List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    private final List<LocalMedia> mediaList;

    public static class Builder {
        private int compressQuality;
        private final Context context;
        private int dataCount;
        private boolean focusAlpha;
        private boolean isAutoRotating;
        private boolean isCamera;
        private OnCompressListener mCompressListener;
        private CompressionPredicate mCompressionPredicate;
        private String mNewFileName;
        private OnRenameListener mRenameListener;
        private String mTargetDir;
        private int mLeastCompressSize = 100;
        private final List<String> mPaths = new ArrayList();
        private List<LocalMedia> mediaList = new ArrayList();
        private final List<InputStreamProvider> mStreamProviders = new ArrayList();

        public Builder(Context context) {
            this.context = context;
        }

        private Luban build() {
            return new Luban(this);
        }

        public Builder filter(CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public File get(final String str) throws IOException {
            return build().get(new InputStreamAdapter() { // from class: com.zyql.ai.selector.compress.Luban.Builder.5
                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            }, this.context);
        }

        public Builder ignoreBy(int i10) {
            this.mLeastCompressSize = i10;
            return this;
        }

        public Builder isAutoRotating(boolean z10) {
            this.isAutoRotating = z10;
            return this;
        }

        public Builder isCamera(boolean z10) {
            this.isCamera = z10;
            return this;
        }

        public void launch() {
            build().launch(this.context);
        }

        public Builder load(InputStreamProvider inputStreamProvider) {
            this.mStreamProviders.add(inputStreamProvider);
            return this;
        }

        public <T> Builder loadMediaData(List<LocalMedia> list) {
            this.mediaList = list;
            this.dataCount = list.size();
            Iterator<LocalMedia> it = list.iterator();
            while (it.hasNext()) {
                load(it.next());
            }
            return this;
        }

        public Builder putGear(int i10) {
            return this;
        }

        public Builder setCompressListener(OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public Builder setCompressQuality(int i10) {
            this.compressQuality = i10;
            return this;
        }

        @Deprecated
        public Builder setFocusAlpha(boolean z10) {
            this.focusAlpha = z10;
            return this;
        }

        public Builder setNewCompressFileName(String str) {
            this.mNewFileName = str;
            return this;
        }

        @Deprecated
        public Builder setRenameListener(OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public Builder setTargetDir(String str) {
            this.mTargetDir = str;
            return this;
        }

        private Builder load(final LocalMedia localMedia) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.zyql.ai.selector.compress.Luban.Builder.1
                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return localMedia;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public String getPath() {
                    if (localMedia.isCut()) {
                        return localMedia.getCutPath();
                    }
                    boolean zIsEmpty = TextUtils.isEmpty(localMedia.getAndroidQToPath());
                    LocalMedia localMedia2 = localMedia;
                    return zIsEmpty ? localMedia2.getPath() : localMedia2.getAndroidQToPath();
                }

                @Override // com.zyql.ai.selector.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    if (PictureMimeType.isContent(localMedia.getPath()) && !localMedia.isCut()) {
                        return TextUtils.isEmpty(localMedia.getAndroidQToPath()) ? PictureContentResolver.getContentResolverOpenInputStream(Builder.this.context, Uri.parse(localMedia.getPath())) : new FileInputStream(localMedia.getAndroidQToPath());
                    }
                    if (PictureMimeType.isHasHttp(localMedia.getPath()) && TextUtils.isEmpty(localMedia.getCutPath())) {
                        return null;
                    }
                    boolean zIsCut = localMedia.isCut();
                    LocalMedia localMedia2 = localMedia;
                    return new FileInputStream(zIsCut ? localMedia2.getCutPath() : localMedia2.getPath());
                }
            });
            return this;
        }

        public List<LocalMedia> get() throws Exception {
            return build().get(this.context);
        }

        public Builder load(final Uri uri) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.zyql.ai.selector.compress.Luban.Builder.2
                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public String getPath() {
                    return uri.getPath();
                }

                @Override // com.zyql.ai.selector.compress.InputStreamAdapter
                public InputStream openInternal() {
                    return PictureContentResolver.getContentResolverOpenInputStream(Builder.this.context, uri);
                }
            });
            return this;
        }

        public Builder load(final File file) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.zyql.ai.selector.compress.Luban.Builder.3
                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public String getPath() {
                    return file.getAbsolutePath();
                }

                @Override // com.zyql.ai.selector.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(file);
                }
            });
            return this;
        }

        public Builder load(final String str) {
            this.mStreamProviders.add(new InputStreamAdapter() { // from class: com.zyql.ai.selector.compress.Luban.Builder.4
                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public LocalMedia getMedia() {
                    return null;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamProvider
                public String getPath() {
                    return str;
                }

                @Override // com.zyql.ai.selector.compress.InputStreamAdapter
                public InputStream openInternal() throws IOException {
                    return new FileInputStream(str);
                }
            });
            return this;
        }

        public <T> Builder load(List<T> list) {
            for (T t10 : list) {
                if (t10 instanceof String) {
                    load((String) t10);
                } else if (t10 instanceof File) {
                    load((File) t10);
                } else if (t10 instanceof Uri) {
                    load((Uri) t10);
                } else {
                    throw new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File compress(Context context, InputStreamProvider inputStreamProvider) throws Exception {
        try {
            return compressRealLocalMedia(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    private File compressReal(Context context, InputStreamProvider inputStreamProvider) throws IOException {
        Checker checker = Checker.SINGLE;
        String strExtSuffix = checker.extSuffix(inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "");
        TextUtils.isEmpty(strExtSuffix);
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            imageCacheFile = getImageCustomFile(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        File file = imageCacheFile;
        CompressionPredicate compressionPredicate = this.mCompressionPredicate;
        if (compressionPredicate != null) {
            return (compressionPredicate.apply(inputStreamProvider.getPath()) && checker.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) ? new Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress() : new File(inputStreamProvider.getPath());
        }
        if (!strExtSuffix.startsWith(".gif") && checker.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) {
            return new Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        }
        return new File(inputStreamProvider.getPath());
    }

    private File compressRealLocalMedia(Context context, InputStreamProvider inputStreamProvider) throws Exception {
        String str;
        LocalMedia media = inputStreamProvider.getMedia();
        String realPath = (!media.isCut() || TextUtils.isEmpty(media.getCutPath())) ? media.getRealPath() : media.getCutPath();
        Checker checker = Checker.SINGLE;
        String strExtSuffix = checker.extSuffix(media.getMimeType());
        File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        if (TextUtils.isEmpty(this.mNewFileName)) {
            str = "";
        } else {
            String strRename = (this.isCamera || this.dataCount == 1) ? this.mNewFileName : StringUtils.rename(this.mNewFileName);
            str = strRename;
            imageCacheFile = getImageCustomFile(context, strRename);
        }
        if (imageCacheFile.exists()) {
            return imageCacheFile;
        }
        if (this.mCompressionPredicate != null) {
            if (strExtSuffix.startsWith(".gif")) {
                return SdkVersionUtils.checkedAndroid_Q() ? (!media.isCut() || TextUtils.isEmpty(media.getCutPath())) ? new File(AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getMedia().getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str)) : new File(media.getCutPath()) : new File(realPath);
            }
            boolean zNeedCompressToLocalMedia = checker.needCompressToLocalMedia(this.mLeastCompressSize, realPath);
            if (this.mCompressionPredicate.apply(realPath) && zNeedCompressToLocalMedia) {
                return new Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
            }
            File file = imageCacheFile;
            if (zNeedCompressToLocalMedia) {
                return new Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
            }
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                return new File(realPath);
            }
            String cutPath = media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
            if (!TextUtils.isEmpty(cutPath)) {
                realPath = cutPath;
            }
            return new File(realPath);
        }
        if (strExtSuffix.startsWith(".gif")) {
            if (!SdkVersionUtils.checkedAndroid_Q()) {
                return new File(realPath);
            }
            String cutPath2 = media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
            if (!TextUtils.isEmpty(cutPath2)) {
                realPath = cutPath2;
            }
            return new File(realPath);
        }
        if (checker.needCompressToLocalMedia(this.mLeastCompressSize, realPath)) {
            return new Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        }
        if (!SdkVersionUtils.checkedAndroid_Q()) {
            return new File(realPath);
        }
        String cutPath3 = media.isCut() ? media.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
        if (!TextUtils.isEmpty(cutPath3)) {
            realPath = cutPath3;
        }
        return new File(realPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File get(InputStreamProvider inputStreamProvider, Context context) throws Throwable {
        InputStreamProvider inputStreamProvider2;
        try {
            inputStreamProvider2 = inputStreamProvider;
            try {
                File fileCompress = new Engine(context, inputStreamProvider2, getImageCacheFile(context, inputStreamProvider, Checker.SINGLE.extSuffix(inputStreamProvider.getMedia().getMimeType())), this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
                inputStreamProvider2.close();
                return fileCompress;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                inputStreamProvider2.close();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamProvider2 = inputStreamProvider;
        }
    }

    private static File getImageCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "default disk cache dir is null");
            }
            return null;
        }
        if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
            return externalFilesDir;
        }
        return null;
    }

    private File getImageCacheFile(Context context, InputStreamProvider inputStreamProvider, String str) {
        String string;
        File imageCacheDir;
        if (TextUtils.isEmpty(this.mTargetDir) && (imageCacheDir = getImageCacheDir(context)) != null) {
            this.mTargetDir = imageCacheDir.getAbsolutePath();
        }
        try {
            LocalMedia media = inputStreamProvider.getMedia();
            String encryptionValue = StringUtils.getEncryptionValue(media.getId(), media.getWidth(), media.getHeight());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mTargetDir);
            if (!TextUtils.isEmpty(encryptionValue) || media.isCut()) {
                sb2.append("/IMG_CMP_");
                sb2.append(encryptionValue);
                if (TextUtils.isEmpty(str)) {
                    str = PictureMimeType.JPG;
                }
                sb2.append(str);
                string = sb2.toString();
            } else {
                String createFileName = DateUtils.getCreateFileName("IMG_CMP_");
                sb2.append("/");
                sb2.append(createFileName);
                if (TextUtils.isEmpty(str)) {
                    str = PictureMimeType.JPG;
                }
                sb2.append(str);
                string = sb2.toString();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            string = "";
        }
        return new File(string);
    }

    private File getImageCustomFile(Context context, String str) {
        if (TextUtils.isEmpty(this.mTargetDir)) {
            File imageCacheDir = getImageCacheDir(context);
            this.mTargetDir = imageCacheDir != null ? imageCacheDir.getAbsolutePath() : "";
        }
        return new File(this.mTargetDir + "/" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launch(final Context context) {
        List<InputStreamProvider> list = this.mStreamProviders;
        if (list == null || this.mPaths == null || (list.size() == 0 && this.mCompressListener != null)) {
            this.mCompressListener.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        final Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        OnCompressListener onCompressListener = this.mCompressListener;
        if (onCompressListener != null) {
            onCompressListener.onStart();
        }
        PictureThreadUtils.executeBySingle(new PictureThreadUtils.SimpleTask<List<LocalMedia>>() { // from class: com.zyql.ai.selector.compress.Luban.1
            /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List<com.zyql.ai.selector.entity.LocalMedia> doInBackground() {
                /*
                    Method dump skipped, instructions count: 320
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.compress.Luban.AnonymousClass1.doInBackground():java.util.List");
            }

            @Override // com.zyql.ai.selector.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMedia> list2) {
                if (Luban.this.mCompressListener == null) {
                    return;
                }
                if (list2 != null) {
                    Luban.this.mCompressListener.onSuccess(list2);
                } else {
                    Luban.this.mCompressListener.onError(new Throwable("Failed to compress file"));
                }
            }
        });
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    private Luban(Builder builder) {
        this.index = -1;
        this.mPaths = builder.mPaths;
        this.mediaList = builder.mediaList;
        this.dataCount = builder.dataCount;
        this.mTargetDir = builder.mTargetDir;
        this.mNewFileName = builder.mNewFileName;
        this.mRenameListener = builder.mRenameListener;
        this.mStreamProviders = builder.mStreamProviders;
        this.mCompressListener = builder.mCompressListener;
        this.mLeastCompressSize = builder.mLeastCompressSize;
        this.mCompressionPredicate = builder.mCompressionPredicate;
        this.compressQuality = builder.compressQuality;
        this.isAutoRotating = builder.isAutoRotating;
        this.focusAlpha = builder.focusAlpha;
        this.isCamera = builder.isCamera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<LocalMedia> get(Context context) throws Exception {
        File fileCompress;
        ArrayList arrayList = new ArrayList();
        Iterator<InputStreamProvider> it = this.mStreamProviders.iterator();
        while (it.hasNext()) {
            InputStreamProvider next = it.next();
            if (next.getMedia() != null) {
                LocalMedia media = next.getMedia();
                if (media.isCompressed() && !TextUtils.isEmpty(media.getCompressPath())) {
                    if (!media.isCut() && new File(media.getCompressPath()).exists()) {
                        fileCompress = new File(media.getCompressPath());
                    } else {
                        fileCompress = compress(context, next);
                    }
                    if (fileCompress != null) {
                        String absolutePath = fileCompress.getAbsolutePath();
                        media.setCompressed(true);
                        media.setCompressPath(absolutePath);
                        if (SdkVersionUtils.checkedAndroid_Q()) {
                            media.setAndroidQToPath(absolutePath);
                        }
                    }
                    arrayList.add(media);
                } else {
                    boolean z10 = PictureMimeType.isHasHttp(media.getPath()) && TextUtils.isEmpty(media.getCutPath());
                    boolean zIsHasVideo = PictureMimeType.isHasVideo(media.getMimeType());
                    File file = (z10 || zIsHasVideo) ? new File(media.getPath()) : compress(context, next);
                    if (file != null) {
                        String absolutePath2 = file.getAbsolutePath();
                        boolean z11 = !TextUtils.isEmpty(absolutePath2) && PictureMimeType.isHasHttp(absolutePath2);
                        media.setCompressed((zIsHasVideo || z11) ? false : true);
                        if (zIsHasVideo || z11) {
                            absolutePath2 = null;
                        }
                        media.setCompressPath(absolutePath2);
                        if (SdkVersionUtils.checkedAndroid_Q()) {
                            media.setAndroidQToPath(media.getCompressPath());
                        }
                    }
                    arrayList.add(media);
                }
                it.remove();
            }
        }
        return arrayList;
    }
}
