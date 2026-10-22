package com.jeffmony.async.http;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Headers {

    /* JADX INFO: renamed from: com.jeffmony.async.http.Headers$1, reason: invalid class name */
    public class AnonymousClass1 extends Multimap {
        final /* synthetic */ Headers this$0;

        public AnonymousClass1(Headers r10) {
        }

        @Override // com.jeffmony.async.http.Multimap
        public List<String> newList() {
            return new TaggedList();
        }
    }
}
