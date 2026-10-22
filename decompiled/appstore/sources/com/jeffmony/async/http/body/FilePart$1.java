package com.jeffmony.async.http.body;

import com.jeffmony.async.http.NameValuePair;
import com.jeffmony.async.http.b;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class FilePart$1 extends ArrayList<NameValuePair> {
    final /* synthetic */ File val$file;

    public FilePart$1(File r10) {
        this.val$file = r10;
        add(new b("filename", r10.getName()));
    }
}
