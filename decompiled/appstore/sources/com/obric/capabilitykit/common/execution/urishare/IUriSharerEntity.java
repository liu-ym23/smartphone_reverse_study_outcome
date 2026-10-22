package com.obric.capabilitykit.common.execution.urishare;

import android.net.Uri;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharable;", "getSharedUris", "", "Landroid/net/Uri;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IUriSharerEntity extends IUriSharable {
    @NotNull
    List<Uri> getSharedUris();
}
