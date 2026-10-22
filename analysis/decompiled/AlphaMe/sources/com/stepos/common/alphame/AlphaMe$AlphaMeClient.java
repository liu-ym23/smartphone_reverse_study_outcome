package com.stepos.common.alphame;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
class AlphaMe$AlphaMeClient extends AlphaMeClientNative {
    final /* synthetic */ f this$0;

    private AlphaMe$AlphaMeClient(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.stepos.common.alphame.IAlphaMeClient
    public void onReceiver(Args args) throws RemoteException {
        Object[] objArr = args.f11220a;
        if (objArr.length == 0) {
            Log.e("AlphaMe", "onReceiver return empty value");
            return;
        }
        String str = (String) objArr[0];
        Object obj = objArr[1];
        b bVarB = this.this$0.b(((Integer) objArr[2]).intValue());
        if (bVarB != null) {
            bVarB.onReceiver(str, obj);
        }
    }

    @Override // com.stepos.common.alphame.IAlphaMeClient
    public void onResult(Args args) throws RemoteException {
        long j4;
        d dVar;
        Object[] objArr = args.f11220a;
        if (objArr.length == 0) {
            Log.e("AlphaMe", "onResult return empty value");
            return;
        }
        Object obj = objArr[0];
        int iIntValue = ((Integer) objArr[1]).intValue();
        f fVar = this.this$0;
        synchronized (fVar) {
            j4 = iIntValue;
            dVar = (d) fVar.f11227a.get(j4);
        }
        if (dVar != null) {
            dVar.f11225a = obj;
            f fVar2 = this.this$0;
            synchronized (fVar2) {
                fVar2.f11227a.remove(j4);
            }
        }
    }

    public /* synthetic */ AlphaMe$AlphaMeClient(f fVar, a aVar) {
        this(fVar);
    }
}
