package com.uxsense.file;

import C7.r;
import H7.c;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086H¢\u0006\u0004\b\t\u0010\n\u001a8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086H¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086H¢\u0006\u0004\b\u000e\u0010\n\u001a2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0010\u0010\b\u001a@\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0011H\u0086H¢\u0006\u0004\b\u0013\u0010\u0014\u001aV\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u00112\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0011H\u0086H¢\u0006\u0004\b\u0017\u0010\u0018\u001aV\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u00112\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0011H\u0086H¢\u0006\u0004\b\u001a\u0010\u0018\u001a@\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0011H\u0086H¢\u0006\u0004\b\u001b\u0010\u0014\u001aB\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0004\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0011H\u0086H¢\u0006\u0004\b\u001c\u0010\u0014¨\u0006\u001d"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/uxsense/file/FileStorageManager;", "Ljava/nio/file/Path;", SingleFileBundle.KEY_PATH, SettingsConfig.KEY_DATA, "Lcom/uxsense/file/FileResult;", "LC7/r;", "writeJsonTyped", "(Lcom/uxsense/file/FileStorageManager;Ljava/nio/file/Path;Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "readJsonTyped", "(Lcom/uxsense/file/FileStorageManager;Ljava/nio/file/Path;LH7/c;)Ljava/lang/Object;", "", "writeJsonList", "(Lcom/uxsense/file/FileStorageManager;Ljava/nio/file/Path;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "readJsonList", "item", "appendJsonToList", "Lkotlin/Function1;", "transform", "updateJson", "(Lcom/uxsense/file/FileStorageManager;Ljava/nio/file/Path;LS7/k;LH7/c;)Ljava/lang/Object;", "", "predicate", "updateJsonItem", "(Lcom/uxsense/file/FileStorageManager;Ljava/nio/file/Path;LS7/k;LS7/k;LH7/c;)Ljava/lang/Object;", "", "updateJsonItems", "removeJsonItem", "findJsonItem", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonFileOperatorKt {
    public static final <T> Object appendJsonToList(FileStorageManager fileStorageManager, Path path, T t9, c<? super FileResult<r>> cVar) {
        try {
            if (((Boolean) fileStorageManager.exists(path, cVar)).booleanValue()) {
                k.m();
                throw null;
            }
            new ArrayList().add(t9);
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.WriteError(path, e));
        }
    }

    public static final <T> Object findJsonItem(FileStorageManager fileStorageManager, Path path, S7.k kVar, c<? super FileResult<? extends T>> cVar) {
        try {
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.ReadError(path, e));
        }
    }

    public static final <T> Object readJsonList(FileStorageManager fileStorageManager, Path path, c<? super FileResult<? extends List<? extends T>>> cVar) {
        k.m();
        throw null;
    }

    public static final <T> Object readJsonTyped(FileStorageManager fileStorageManager, Path path, c<? super FileResult<? extends T>> cVar) {
        k.m();
        throw null;
    }

    public static final <T> Object removeJsonItem(FileStorageManager fileStorageManager, Path path, S7.k kVar, c<? super FileResult<Boolean>> cVar) {
        try {
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.WriteError(path, e));
        }
    }

    public static final <T> Object updateJson(FileStorageManager fileStorageManager, Path path, S7.k kVar, c<? super FileResult<r>> cVar) {
        try {
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.WriteError(path, e));
        }
    }

    public static final <T> Object updateJsonItem(FileStorageManager fileStorageManager, Path path, S7.k kVar, S7.k kVar2, c<? super FileResult<Boolean>> cVar) {
        try {
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.WriteError(path, e));
        }
    }

    public static final <T> Object updateJsonItems(FileStorageManager fileStorageManager, Path path, S7.k kVar, S7.k kVar2, c<? super FileResult<Integer>> cVar) {
        try {
            k.m();
            throw null;
        } catch (Exception e) {
            return new FileResult.Error(new FileException.WriteError(path, e));
        }
    }

    public static final <T> Object writeJsonList(FileStorageManager fileStorageManager, Path path, List<? extends T> list, c<? super FileResult<r>> cVar) {
        k.m();
        throw null;
    }

    public static final <T> Object writeJsonTyped(FileStorageManager fileStorageManager, Path path, T t9, c<? super FileResult<r>> cVar) {
        k.m();
        throw null;
    }
}
