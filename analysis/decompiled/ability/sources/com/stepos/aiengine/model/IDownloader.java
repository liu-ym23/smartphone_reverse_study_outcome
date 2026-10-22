package com.stepos.aiengine.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.deepbinder.core.constant.Constants;
import f5.InterfaceC1435a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\bR\u0014\u0010\u001e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/stepos/aiengine/model/IDownloader;", "", "Landroid/os/Bundle;", "bundle", "LC7/r;", "start", "(Landroid/os/Bundle;)V", "pause", "()V", "resume", "cancel", "", "getProgress", "()I", "", "id", "Lf5/a;", "callback", "registerCallback", "(Ljava/lang/String;Lf5/a;)V", "unregisterCallback", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "Landroid/os/ParcelFileDescriptor;", Constants.GET_FILE_DESCRIPTOR, "()Landroid/os/ParcelFileDescriptor;", "destroy", "getStatus", "status", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IDownloader {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void start$default(IDownloader iDownloader, Bundle bundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i & 1) != 0) {
                bundle = null;
            }
            iDownloader.start(bundle);
        }
    }

    void cancel();

    void destroy();

    ParcelFileDescriptor getFileDescriptor();

    Uri getFileUri();

    int getProgress();

    int getStatus();

    void pause();

    void registerCallback(String id, InterfaceC1435a callback);

    void resume();

    void start(Bundle bundle);

    void unregisterCallback(String id);
}
