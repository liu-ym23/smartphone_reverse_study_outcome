package com.stepos.alphame.request;

import android.content.Context;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.stepos.alphame.NotProguard;
import java.io.File;

@NotProguard
/* loaded from: classes.dex */
public class RequestQueue {
    private static com.android.volley.RequestQueue sRequestQueue;

    public static synchronized com.android.volley.RequestQueue getQueue(Context context) {
        try {
            if (sRequestQueue == null) {
                com.android.volley.RequestQueue requestQueueNewRequestQueue = newRequestQueue(context, null, 4);
                sRequestQueue = requestQueueNewRequestQueue;
                requestQueueNewRequestQueue.start();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sRequestQueue;
    }

    public static com.android.volley.RequestQueue newRequestQueue(Context context, HttpStack httpStack, int i4) {
        File file = new File(context.getExternalCacheDir(), "volley");
        if (httpStack == null) {
            try {
                httpStack = new HurlStack(null, KeyPinStore.getInstance().getContext().getSocketFactory());
            } catch (Exception e4) {
                e4.printStackTrace();
                httpStack = new HurlStack();
            }
        }
        com.android.volley.RequestQueue requestQueue = new com.android.volley.RequestQueue(new DiskBasedCache(file), new BasicNetwork(httpStack));
        requestQueue.start();
        return requestQueue;
    }

    public static com.android.volley.RequestQueue newSingleThreadRequestQueue(Context context) {
        return newRequestQueue(context, 1);
    }

    public static com.android.volley.RequestQueue newRequestQueue(Context context, int i4) {
        return newRequestQueue(context, null, i4);
    }
}
