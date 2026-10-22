package com.bytedance.services.apm.api;

import B.b;
import B.e;
import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IHttpService extends IService {
    e buildMultipartUpload(String str, String str2, Map<String, String> map, boolean z10);

    e buildMultipartUpload(String str, String str2, boolean z10);

    b doGet(String str, Map<String, String> map);

    b doPost(String str, byte[] bArr, Map<String, String> map);

    b uploadFiles(String str, List<File> list, Map<String, String> map);
}
