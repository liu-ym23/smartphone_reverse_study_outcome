package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpService extends IService {
    IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3) throws Exception;

    IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) throws Exception;

    HttpResponse doGet(String r1, Map<String, String> r2) throws Exception;

    HttpResponse doPost(String r1, byte[] r2, Map<String, String> r3) throws Exception;

    HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) throws Exception;
}
